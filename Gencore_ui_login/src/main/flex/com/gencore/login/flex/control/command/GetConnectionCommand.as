package com.gencore.login.flex.control.command {


    
    import com.gencore.commons.flex.manager.ErrorManager;
    import com.gencore.commons.flex.model.MainModel;
    import com.gencore.commons.flex.vo.UserProfileVO;
    import com.gencore.login.flex.business.LoginDelegate;
    import com.gencore.login.flex.control.event.LoginEvent;
    
    import mx.controls.Alert;
    import mx.events.ResourceEvent;
    import mx.resources.ResourceManager;
    import mx.rpc.IResponder;
    import mx.rpc.events.FaultEvent;
    import mx.rpc.events.ResultEvent;
    
    import org.lucciframework.luccimvc.controller.command.Command;
    import org.lucciframework.luccimvc.controller.event.LucciEvent;
    import org.lucciframework.luccimvc.controller.event.LucciEventDispatcher;


    public class GetConnectionCommand extends Command implements IResponder {
        [Bindable] public var model : MainModel = MainModel.instance;

        private var loginEvent : LoginEvent;

        override protected function execute(event : LucciEvent) : void {

            loginEvent = LoginEvent(event);

            super.execute(loginEvent);

            var delegate : LoginDelegate = new LoginDelegate(this);

            delegate.getConnection(loginEvent.data["login"], loginEvent.data["password"]);

        }

        override public function result(data : Object) : void {

            var event : ResultEvent = data as ResultEvent;

            model.userConnected = event.result as UserProfileVO;

            LucciEventDispatcher.instance.dispatchEvent(new LoginEvent(LoginEvent.GET_CONNECTION_ACK));
			
			
        }

        override public function fault(data : Object) : void {

            var faultEvt : FaultEvent = data as FaultEvent;

            //if (faultEvt.toString().match(new RegExp ( "Bad credentials" , "i")) ) {

            Alert.show(ErrorManager.displayMessage(faultEvt.fault.faultCode));

            model.userConnected = null;

            LucciEventDispatcher.instance.dispatchEvent(new LoginEvent(LoginEvent.GET_CONNECTION_ACK));
            //}

        }
    }
}