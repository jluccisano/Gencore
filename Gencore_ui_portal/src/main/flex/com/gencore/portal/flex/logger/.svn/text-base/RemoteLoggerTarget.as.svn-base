package com.gencore.portal.flex.logger
{
	import mx.logging.AbstractTarget;
	import mx.logging.LogEvent;
	import mx.logging.LogEventLevel;
	import mx.rpc.remoting.RemoteObject;
	
	import org.lucciframework.luccimvc.business.Services;

	public class RemoteLoggerTarget extends AbstractTarget
	{
		private var remoteLogger:RemoteObject;
		
		override public function logEvent(event:LogEvent):void {
			if(remoteLogger == null) {
				
				remoteLogger  = Services.getInstance("appFacade").getRemoteObject("remoteLogger");
			}
			var message:String = event.message;
			
			switch (event.level) {
				case LogEventLevel.DEBUG : remoteLogger.debug(message);break;
				case LogEventLevel.INFO  : remoteLogger.info(message);break;
				case LogEventLevel.WARN  : remoteLogger.warn(message);break;
				case LogEventLevel.ERROR : remoteLogger.error(message);break;
				case LogEventLevel.FATAL : remoteLogger.fatal(message);break;
			}
		}
	}
}