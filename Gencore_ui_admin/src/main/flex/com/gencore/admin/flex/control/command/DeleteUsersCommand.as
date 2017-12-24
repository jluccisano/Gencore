package com.gencore.admin.flex.control.command {

    
    import com.gencore.admin.flex.business.AdminDelegate;
    import com.gencore.admin.flex.control.event.AdminEvent;
    import com.gencore.commons.flex.manager.ErrorManager;
    
    import mx.controls.Alert;
    import mx.rpc.IResponder;
    import mx.rpc.events.FaultEvent;
    import mx.rpc.events.ResultEvent;
    
    import org.lucciframework.luccimvc.controller.command.Command;
    import org.lucciframework.luccimvc.controller.event.LucciEvent;
    import org.lucciframework.luccimvc.controller.event.LucciEventDispatcher;

    public class DeleteUsersCommand extends Command implements IResponder {

        private var adminEvent : AdminEvent;

        override protected function execute(event : LucciEvent) : void {
			adminEvent = AdminEvent(event);

            var delegate : AdminDelegate = new AdminDelegate(this);

            delegate.deleteUsers(adminEvent.data);
        }

        override public function result(data : Object) : void {
            var event : ResultEvent = data as ResultEvent;		

			LucciEventDispatcher.instance.dispatchEvent(new AdminEvent(AdminEvent.DELETE_USERS_ACK));
        }

        override public function fault(data : Object) : void {
			var faultEvt : FaultEvent = data as FaultEvent;
			
			Alert.show(ErrorManager.displayMessage(faultEvt.fault.faultCode));
        }
    }
}