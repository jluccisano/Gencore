
package com.gencore.login.flex.control.command {


    import com.gencore.assets.ConstIcons;
    import com.gencore.commons.flex.manager.ErrorManager;
    import com.gencore.login.flex.business.UserDelegate;
    import com.gencore.login.flex.control.event.UserEvent;
    
    import mx.controls.Alert;
    import mx.resources.ResourceManager;
    import mx.rpc.IResponder;
    import mx.rpc.events.FaultEvent;
    import mx.rpc.events.ResultEvent;
    
    import org.lucciframework.luccimvc.controller.command.Command;
    import org.lucciframework.luccimvc.controller.event.LucciEvent;
    import org.lucciframework.luccimvc.controller.event.LucciEventDispatcher;


    public class AddUserCommand extends Command implements IResponder {
        private var userEvent : UserEvent;

        override protected function execute(event : LucciEvent) : void {
            userEvent = com.gencore.login.flex.control.event.UserEvent(event);

            var delegate : UserDelegate = new UserDelegate(this);

            delegate.registrationUser(userEvent.data);
        }

        override public function result(data : Object) : void {
            var event : ResultEvent = data as ResultEvent;

            LucciEventDispatcher.instance.dispatchEvent(new UserEvent(UserEvent.REGISTRATION_USER_ACK));
			
			Alert.show(ResourceManager.getInstance().getString('gencore_login', 'gencore.login.module.connection.ack'),
				ResourceManager.getInstance().getString('i18n', 'gencore.portal.info'),
				Alert.OK ,null,null,ConstIcons.checkLargeIcon_32x32,Alert.OK);	
			
        }

        override public function fault(data : Object) : void {
           // LucciEventDispatcher.instance.dispatchEvent(new UserEvent(UserEvent.UPDATE_USER_ACK, data));
			var faultEvt : FaultEvent = data as FaultEvent;
		/*	Alert.show(ErrorManager.displayMessage(faultEvt.fault.faultCode));
			*/
			Alert.show(ErrorManager.displayMessage(faultEvt.fault.faultCode),
				ResourceManager.getInstance().getString('i18n', 'gencore.portal.warning'),
				Alert.OK ,null,null,ConstIcons.warningIcon,Alert.OK);			
			
        }
    }
}