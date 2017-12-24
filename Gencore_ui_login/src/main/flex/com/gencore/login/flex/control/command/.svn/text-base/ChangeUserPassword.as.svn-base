
package com.gencore.login.flex.control.command {


    import com.gencore.login.flex.business.UserDelegate;
    import com.gencore.login.flex.control.event.UserEvent;

    import mx.rpc.IResponder;
    import mx.rpc.events.ResultEvent;

    import org.lucciframework.luccimvc.controller.command.Command;
    import org.lucciframework.luccimvc.controller.event.LucciEvent;
    import org.lucciframework.luccimvc.controller.event.LucciEventDispatcher;


    public class ChangeUserPassword extends Command implements IResponder {
        private var userEvent : UserEvent;

        override protected function execute(event : LucciEvent) : void {
            userEvent = com.gencore.login.flex.control.event.UserEvent(event);

            var delegate : UserDelegate = new UserDelegate(this);

            delegate.updateUser(userEvent.data["user"], userEvent.data["passwords"]);
        }

        override public function result(data : Object) : void {
            var event : ResultEvent = data as ResultEvent;

            LucciEventDispatcher.instance.dispatchEvent(new UserEvent(UserEvent.GET_CURRENT_USER_EVENT));

            LucciEventDispatcher.instance.dispatchEvent(new UserEvent(UserEvent.UPDATE_USER_ACK));

        }

        override public function fault(data : Object) : void {
            LucciEventDispatcher.instance.dispatchEvent(new UserEvent(UserEvent.UPDATE_USER_ACK, data));
        }
    }
}