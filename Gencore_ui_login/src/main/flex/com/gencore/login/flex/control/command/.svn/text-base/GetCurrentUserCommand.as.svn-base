package com.gencore.login.flex.control.command {

    
    import com.gencore.commons.flex.model.MainModel;
    import com.gencore.commons.flex.vo.UserProfileVO;
    import com.gencore.login.flex.business.UserDelegate;
    import com.gencore.login.flex.control.event.UserEvent;
    
    import mx.rpc.IResponder;
    import mx.rpc.events.ResultEvent;
    
    import org.lucciframework.luccimvc.controller.command.Command;
    import org.lucciframework.luccimvc.controller.event.LucciEvent;

    public class GetCurrentUserCommand extends Command implements IResponder {
        [Bindable] public var model : MainModel = MainModel.instance;

        private var userEvent : UserEvent;

        override protected function execute(event : LucciEvent) : void {
            userEvent = UserEvent(event);

            var delegate : UserDelegate = new UserDelegate(this);

            delegate.getCurrentUser();
        }

        override public function result(data : Object) : void {
            var event : ResultEvent = data as ResultEvent;

            model.userConnected = event.result as UserProfileVO;
        }

        override public function fault(data : Object) : void {
            model.userConnected = null;
        }
    }
}