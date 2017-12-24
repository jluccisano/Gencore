package com.gencore.login.flex.control.command {
    import com.gencore.assets.ConstIcons;
    import com.gencore.commons.flex.manager.ErrorManager;
    import com.gencore.login.flex.business.LoginDelegate;
    import com.gencore.login.flex.control.event.LoginEvent;
    
    import mx.controls.Alert;
    import mx.resources.ResourceManager;
    import mx.rpc.IResponder;
    import mx.rpc.events.FaultEvent;
    import mx.rpc.events.ResultEvent;
    
    import org.lucciframework.luccimvc.controller.command.Command;
    import org.lucciframework.luccimvc.controller.event.LucciEvent;



    public class ForgotPasswordCommand extends Command implements IResponder {

        private var loginEvent : LoginEvent;

        override protected function execute(event : LucciEvent) : void {

            loginEvent = LoginEvent(event);

            var delegate : LoginDelegate = new LoginDelegate(this);

            delegate.forgotPassword(loginEvent.data["email"]);

        }

        override public function result(data : Object) : void {
            var event : ResultEvent = data as ResultEvent;
			
			Alert.show(ResourceManager.getInstance().getString('gencore_login', 'gencore.login.module.emailsent'),
				ResourceManager.getInstance().getString('i18n', 'gencore.portal.info'),
				Alert.OK ,null,null,ConstIcons.checkLargeIcon_32x32,Alert.OK);	
			
        }

        override public function fault(data : Object) : void {
			
			var faultEvt : FaultEvent = data as FaultEvent;
			
			Alert.show(ErrorManager.displayMessage(faultEvt.fault.faultCode),
				ResourceManager.getInstance().getString('i18n', 'gencore.portal.warning'),
				Alert.OK ,null,null,ConstIcons.warningIcon,Alert.OK);		
        }
    }
}