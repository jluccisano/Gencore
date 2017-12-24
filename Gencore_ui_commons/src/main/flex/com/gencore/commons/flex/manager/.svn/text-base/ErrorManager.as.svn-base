package com.gencore.commons.flex.manager
{
	import flash.events.Event;
	
	import mx.resources.ResourceManager;
	import mx.utils.StringUtil;

	public class ErrorManager
	{

		[ResourceBundle("exception")]

		public static function displayMessage(errorCode:String, ... rest):String
		{
			var message:String=StringUtil.substitute(ResourceManager.getInstance().getString('exception', errorCode), rest);
	Event.PASTE
			return StringUtil.substitute("{0}", message);
		}
	}
}