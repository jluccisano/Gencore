package com.gencore.login.flex.control.event
{
	import flash.utils.Dictionary;
	
	import org.lucciframework.luccimvc.controller.event.LucciEvent;

	public class UserEvent extends LucciEvent
	{
		public static const ADD_USER_EVENT : String='add_user_event';
		public static const REGISTRATION_USER_EVENT : String='registration_user_event';
		public static const UPDATE_USER_EVENT : String='update_user_event';
		public static const GET_CURRENT_USER_EVENT : String='get_current_user_event';
		public static const COMPRESS_IMAGE_EVENT : String='compress_image_event';
		
		public static const ADD_USER_ACK : String='add_user_ack';
		public static const REGISTRATION_USER_ACK : String='registration_user_ack';
		public static const UPDATE_USER_ACK : String='update_user_ack';
		public static const GET_CURRENT_USER_ACK : String='get_current_user_ack';
		public static const COMPRESS_IMAGE_ACK : String='compress_image_ack';

		public var id : String;
			
		public function UserEvent( type : String , data : * = null,  id:String = null, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type,data,id,bubbles,cancelable);
			this.id = id;
			this.data = data;
		}
		
		private var _data : *;
	}
}