package com.gencore.admin.flex.business {
    import mx.collections.ArrayCollection;
    import mx.rpc.remoting.RemoteObject;
    
    import org.lucciframework.luccimvc.business.*;

    public class AdminDelegate {
        import mx.rpc.AsyncToken;
        import mx.rpc.IResponder;

        private var responder : IResponder;
        private var service : RemoteObject;

        public function AdminDelegate(responder : IResponder) {
            this.service = Services.getInstance("adminFacade").getRemoteObject("userService");
            this.responder = responder;
        }


        public function getUsers() : void {
            var call : AsyncToken = service.getUsers();
            call.addResponder(responder);
        }
		
		public function deleteUsers(users:ArrayCollection) : void {
			var call : AsyncToken = service.deleteUsers(users);
			call.addResponder(responder);
		}




    }
}