package com.gencore.login.flex.view.mediator {

    import com.gencore.commons.flex.manager.GencoreModuleManager;
    import com.gencore.commons.flex.model.MainModel;
    import com.gencore.login.flex.control.event.LoginEvent;
    import com.gencore.login.flex.view.LoginUI;
    
    import flash.utils.Dictionary;
    
    import mx.resources.ResourceManager;
    
    import org.lucciframework.luccimvc.controller.event.LucciEventDispatcher;
    import org.lucciframework.luccimvc.facade.Facade;
    import org.lucciframework.luccimvc.view.mediator.Mediator;
    


    public class LoginMediator extends Mediator {

        [Bindable] public var model : MainModel = MainModel.instance;

        [Bindable] public var moduleManager : GencoreModuleManager = GencoreModuleManager.instance;


        private function onResult(loginEvent : LoginEvent) : void {

            switch (loginEvent.type) {
                case (LoginEvent.GET_CONNECTION_ACK):

                    LucciEventDispatcher.instance.removeEventListener(LoginEvent.GET_CONNECTION_ACK, onResult);

                    if (model.userConnected != null) {

                        moduleManager.unloadModule(MainModel.HOME_MODULE);
                        Facade.removeCore("homeFacade");
						
						//Set language
						ResourceManager.getInstance().localeChain = [model.userConnected.language];
						
			
                       // model.connected = true;
						
						(this.getViewComponent("loginUI") as LoginUI).currentState = "STATE_CONNECTED";

                        //PopUpManager.removePopUp(this.getViewComponent("loginUI") as LoginUI);

                        switch (model.userConnected.role.name) {

                            case 'ROLE_ADMIN':
                                moduleManager.loadModule(MainModel.ADMIN_MODULE);
                                break;
                            case 'ROLE_USER':
                                moduleManager.loadModule(MainModel.TRACKER_MODULE);
                                break;
                        }
                        break;
                    } else {
                        //(this.getViewComponent("loginUI") as LoginUI).bad_credentials_lbl.visible = true;
                    }

            }
        }


        public function getConnection(login : String, password : String) : void {

            var data : Dictionary = new Dictionary();
            data["login"] = login;
            data["password"] = password;

            LucciEventDispatcher.instance.addEventListener(LoginEvent.GET_CONNECTION_ACK, onResult);

            LucciEventDispatcher.instance.dispatchEvent(new LoginEvent(LoginEvent.GET_CONNECTION_EVENT, data));
        }

        public function forgotPassword(email : String) : void {

            var data : Dictionary = new Dictionary();
            data["email"] = email;

            LucciEventDispatcher.instance.dispatchEvent(new LoginEvent(LoginEvent.FORGOT_PASSWORD_EVENT, data));
        }

    }
}