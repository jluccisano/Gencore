package com.gencore.tracker.flex.business
{
	import com.gencore.commons.flex.vo.UserProfileVO;
	
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
			this.service = Services.getInstance("trackerFacade").getRemoteObject("trackerService");
			this.responder = responder;
		}  

		public function getCoursesOfUser ( user : UserProfileVO ) : void { 	
			var call:AsyncToken = service.getCoursesOfUser( user );
			call.addResponder(responder);
		} 
		
		public function getCourseById ( courseId : String ) : void { 	
			var call:AsyncToken = service.getCourseById( courseId );
			call.addResponder(responder);
		}    
	
	}
}