package com.gencore.admin.flex.view.mediator {

    
    import com.gencore.admin.flex.control.event.AdminEvent;
    import com.gencore.commons.flex.manager.GencoreModuleManager;
    import com.gencore.commons.flex.model.MainModel;
    import com.gencore.commons.flex.vo.UserProfileVO;
    
    import flash.utils.Dictionary;
    
    import mx.charts.AreaChart;
    import mx.collections.ArrayCollection;
    import mx.managers.PopUpManager;
    import mx.rpc.events.FaultEvent;
    
    import org.lucciframework.luccimvc.controller.event.LucciEventDispatcher;
    import org.lucciframework.luccimvc.view.mediator.Mediator;

    public class AdminMediator extends Mediator {
		
		[Bindable]
		public var users:ArrayCollection;

        private function onResult(adminEvent : AdminEvent) : void {

            switch (adminEvent.type) {
                case (AdminEvent.GET_USERS_ACK):

                    LucciEventDispatcher.instance.removeEventListener(AdminEvent.GET_USERS_ACK, onResult);

					users = adminEvent.data;
					
                    break;
				
				case (AdminEvent.DELETE_USERS_ACK):
					
					LucciEventDispatcher.instance.removeEventListener(AdminEvent.DELETE_USERS_ACK, onResult);
					
					getUsers();
					
					break;
            }
        }

        public function getUsers() : void {

            LucciEventDispatcher.instance.addEventListener(AdminEvent.GET_USERS_ACK, onResult);

            LucciEventDispatcher.instance.dispatchEvent(new AdminEvent(AdminEvent.GET_USERS_EVENT));
        }
		
		public function deleteUsers(users:ArrayCollection) : void {
			
			LucciEventDispatcher.instance.addEventListener(AdminEvent.DELETE_USERS_ACK, onResult);
			
			LucciEventDispatcher.instance.dispatchEvent(new AdminEvent(AdminEvent.DELETE_USERS_EVENT,users));
		}

    }
}