package com.gencore.login.flex.business {
    import mx.rpc.remoting.RemoteObject;

    import org.lucciframework.luccimvc.business.*;

    public class LoginDelegate {
        import mx.rpc.AsyncToken;
        import mx.rpc.IResponder;

        private var responder : IResponder;
        private var service : RemoteObject;

        public function LoginDelegate(responder : IResponder) {
            this.service = Services.getInstance("loginFacade").getRemoteObject("userService");
            this.responder = responder;
        }


        public function getConnection(login : String, password : String) : void {
            var call : AsyncToken = service.getConnection(login, password);
            call.addResponder(responder);
        }

        public function forgotPassword(email : String) : void {
            var call : AsyncToken = service.forgotPassword(email);
            call.addResponder(responder);
        }


    }
}