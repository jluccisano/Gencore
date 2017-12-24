package com.gencore.commons.flex.utils
{
	public class GPSUtils
	{
		
		public static const millisecondsPerMinute:int = 1000 * 60;
		
		public static function getDistanceBetween2Coordinates( lat1:Number,long1:Number,lat2:Number,long2:Number):Number {
			
			var d:Number=0;
			
			var a:Number = Math.PI / 180;
			var rLat1:Number = lat1 * a;
			var rLat2:Number = lat2 * a;
			var rLong1:Number = long1 * a;
			var rLong2:Number = long2 * a;
			
			
			var t1:Number  = Math.sin(rLat1) * Math.sin(rLat2);
			var t2:Number = Math.cos(rLat1) * Math.cos(rLat2);
			var t3:Number = Math.cos(rLong1 - rLong2);
			var t4:Number = t2 * t3;
			var t5:Number = t1 + t4;
			var rad_dist:Number = Math.atan(-t5/Math.sqrt(-t5 * t5 +1)) + 2 * Math.atan(1);
			
			d = (rad_dist * 3437.74677 * 1.1508) * 1.6093470878864446;
			
			
			return d;
		}
		
		public static function convertMillisecondsToHHMMSS(timeMillis:Number):String {
			
			var time:Number = Math.floor(timeMillis / 1000);  
			
			var seconds:String;
			var minutes : String;
			var hours : String;
			
			var secs:Number;
			var mins : Number;
			var hrs : Number;
			
			if(time > 0) {
				secs = time % 60;
				seconds = secs.toString();
				if(secs < 10) {
					seconds = "0" + secs.toString();
				}
			}	
			
			if(time > 60) {
				mins = (Math.floor(time / 60) % 60);
				minutes = mins.toString();
				if(mins < 10) {
					minutes = "0" + mins.toString();
				}
			} else {
				minutes = "00";
			}
			
			if(time > 3600) {
				hrs =  (Math.floor(mins / 60) % 60);
				hours = hrs.toString();
				if(hrs < 10) {
					hours = "0" + hrs.toString();
				}
			} else {
				hours = "00";
			}
			
			return hours + ":" + minutes + ":" + seconds;
			
			
		}
	}
}