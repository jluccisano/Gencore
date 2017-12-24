package com.gencore.login.flex.view.mediator {

    
    import com.gencore.commons.flex.manager.GencoreModuleManager;
    import com.gencore.commons.flex.model.MainModel;
    import com.gencore.commons.flex.vo.UserProfileVO;
    import com.gencore.login.flex.control.event.UserEvent;
    import com.gencore.login.flex.view.UserPopup;
    
    import flash.utils.ByteArray;
    import flash.utils.Dictionary;
    
    import mx.managers.PopUpManager;
    import mx.rpc.events.FaultEvent;
    
    import org.lucciframework.luccimvc.controller.event.LucciEventDispatcher;
    import org.lucciframework.luccimvc.view.mediator.Mediator;

    public class UserMediator extends Mediator {
        [Bindable] public var model : MainModel = MainModel.instance;

        [Bindable] public var moduleManager : GencoreModuleManager = GencoreModuleManager.instance;

        public function UserMediator() {
        }

        private function onResult(userEvent : UserEvent) : void {

            switch (userEvent.type) {
                case (UserEvent.UPDATE_USER_ACK):

                    LucciEventDispatcher.instance.removeEventListener(UserEvent.UPDATE_USER_ACK, onResult);

                    if (userEvent.data is FaultEvent) {

                    } else {
                        PopUpManager.removePopUp(this.getViewComponent("userUI") as UserPopup);
                    }
                    break;
				case (UserEvent.REGISTRATION_USER_ACK):
					
					LucciEventDispatcher.instance.removeEventListener(UserEvent.REGISTRATION_USER_ACK, onResult);
					
					if (userEvent.data is FaultEvent) {
						
					} else {
						PopUpManager.removePopUp(this.getViewComponent("userUI") as UserPopup);
					}
					
					
					//Gestion des différentes erreurs possible
					
					//Email déjà existant
					//Mot de passe existant
					//Login existant
					if (userEvent.data is FaultEvent) {
						
					} else {
						
					}
					break;
				
				case (UserEvent.COMPRESS_IMAGE_ACK):
					
						LucciEventDispatcher.instance.removeEventListener(UserEvent.COMPRESS_IMAGE_ACK, onResult);
					
						(this.getViewComponent("userUI") as UserPopup).photo = userEvent.data;
					
					break;
            }
			
			
        }

        public function updateUser(user : UserProfileVO, passwords : Object) : void {

            var data : Dictionary = new Dictionary();
            data["user"] = user;
            data["passwords"] = passwords;

            LucciEventDispatcher.instance.addEventListener(UserEvent.UPDATE_USER_ACK, onResult);

            LucciEventDispatcher.instance.dispatchEvent(new UserEvent(UserEvent.UPDATE_USER_EVENT, data));
        }
		
		public function registrationUser (user : UserProfileVO) : void {
			
			LucciEventDispatcher.instance.addEventListener(UserEvent.REGISTRATION_USER_ACK, onResult);
			
			LucciEventDispatcher.instance.dispatchEvent(new UserEvent(UserEvent.REGISTRATION_USER_EVENT, user));
			
		}
		
		public function compressImage(image:ByteArray) :void {
			
			LucciEventDispatcher.instance.addEventListener(UserEvent.COMPRESS_IMAGE_ACK, onResult);
			
			LucciEventDispatcher.instance.dispatchEvent(new UserEvent(UserEvent.COMPRESS_IMAGE_EVENT, image));
		}

    }
}