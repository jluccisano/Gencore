package com.gencore.login.flex.business {

    
    import com.gencore.commons.flex.vo.UserProfileVO;
    
    import flash.utils.ByteArray;
    
    import mx.rpc.remoting.RemoteObject;
    
    import org.lucciframework.luccimvc.business.Services;

    public class UserDelegate {
        import mx.rpc.AsyncToken;
        import mx.rpc.IResponder;

        private var responder : IResponder;
        private var service : RemoteObject;

        public function UserDelegate(responder : IResponder) {
            this.service = Services.getInstance("loginFacade").getRemoteObject("userService");
            this.responder = responder;
        }

        public function updateUser(user : UserProfileVO, passwords : Object) : void {

            var call : AsyncToken;

            if (passwords != null) {
                call = service.updateUser(user, passwords);
            } else {
                call = service.updateUser(user);
            }

            call.addResponder(responder);
        }

        public function getCurrentUser() : void {
            var call : AsyncToken = service.getCurrentUser();
            call.addResponder(responder);
        }
		
		public function registrationUser(user:UserProfileVO) : void {
			var call : AsyncToken = service.registrationUser(user);
			call.addResponder(responder);
		}
		
		public function compressImage(image:ByteArray) : void {
			var call : AsyncToken = service.compressImage(image);
			call.addResponder(responder);
		}
    }
}