package com.gencore.login.flex.control.event
{
	import flash.utils.Dictionary;
	
	import org.lucciframework.luccimvc.controller.event.LucciEvent;
	
	
	public class LoginEvent extends LucciEvent
	{
		
		public static const GET_CONNECTION_EVENT : String='get_connection_event';
		public static const GET_CONNECTION_ACK : String ='get_connection_ack';
		
		public static const FORGOT_PASSWORD_EVENT : String ='forgot_password_event';
		
		public var id : String;
		
		
		public function LoginEvent( type : String , data : Dictionary = null,  id:String = null, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type,data,id,bubbles,cancelable);
			this.id = id;
			this.data = data;
		}
		
		private var _data : Dictionary;
		
		/*[Bindable]
		public function get data () : Dictionary {
		return _data;
		}
		
		override public function set data ( value : Dictionary ) : void {
		_data = value;
		}*/
	}
}