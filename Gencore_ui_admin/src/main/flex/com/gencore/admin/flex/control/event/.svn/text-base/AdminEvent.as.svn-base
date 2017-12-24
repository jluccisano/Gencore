package com.gencore.admin.flex.control.event
{
	import flash.utils.Dictionary;
	
	import org.lucciframework.luccimvc.controller.event.LucciEvent;

	public class AdminEvent extends LucciEvent
	{
		public static const GET_USERS_EVENT : String='get_users_event';
		public static const GET_USERS_ACK : String='get_users_ack';
		
		public static const DELETE_USERS_EVENT : String='delete_users_event';
		public static const DELETE_USERS_ACK : String='delete_users_ack';
		
		public var id : String;
			
		public function AdminEvent( type : String , data : * = null,  id:String = null, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type,data,id,bubbles,cancelable);
			this.id = id;
			this.data = data;
		}
		
		private var _data : *;
	}
}