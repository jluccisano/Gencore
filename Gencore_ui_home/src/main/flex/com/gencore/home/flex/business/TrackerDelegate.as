package com.gencore.home.flex.business
{
	import mx.rpc.remoting.RemoteObject;
	
	import org.lucciframework.luccimvc.business.*;
	
	public class TrackerDelegate
	{
		import mx.rpc.AsyncToken;
		import mx.rpc.IResponder;
		
		private var responder : IResponder;
		private var service : RemoteObject;
		
		public function TrackerDelegate(responder : IResponder )
		{
			this.service = Services.getInstance("homeFacade").getRemoteObject("trackerService");
			this.responder = responder;
		}  
		
		
		public function getCoursesOfToday () : void { 	
			var call:AsyncToken = service.getCoursesOfToday();
			call.addResponder(responder);
		}
		
		public function getTotalDistance () : void { 	
			var call:AsyncToken = service.getTotalDistance();
			call.addResponder(responder);
		} 
		
	
	}
}