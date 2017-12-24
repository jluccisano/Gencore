package com.gencore.commons.flex.utils
{
	import mx.controls.DateField;
	import mx.formatters.DateFormatter;
	
	public class DateConstants
	{
		
		
        public static const SUNDAY:uint = 0;
        public static const MONDAY:uint = 1;
        public static const TUESDAY:uint = 2;
        public static const WEDNESDAY:uint = 3;
        public static const THURSDAY:uint = 4;
        public static const FRIDAY:uint = 5;
        public static const SATURDAY:uint = 6;
        
       
        
        public static const DAY_NAMES:Array = ["Dim","Lun","Mar","Mer","Jeu","Ven","Sam"];
        public static const DISABLE_SUN_SAT:Array = [0,6];
        public static const MONTH_NAMES:Array = [{label: "Janvier", month_index: 0 },
        										 {label: "Février", month_index: 1 },
        										 {label: "Mars", month_index: 2 },
        										 {label: "Avril", month_index: 3 },
        										 {label: "Mai", month_index: 4 },
        										 {label: "Juin", month_index: 5 },       										 
        										 {label: "Juillet", month_index: 6 },
        										 {label: "Août", month_index: 7 },
        										 {label: "Septembre", month_index: 8 },
        										 {label: "Octobre", month_index: 9 },
        										 {label: "Novembre", month_index: 10 },
        										 {label: "Décembre", month_index: 11 }];
        
        								 
   		public static const MONTHS:Array = ["Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"];
	
	    
		public static function initializeDateField(date:DateField):void
		{
			date.width = 150;
			date.dayNames = DAY_NAMES;
			date.monthNames = MONTHS;
			date.formatString = "DD/MM/YYYY";
			date.firstDayOfWeek = MONDAY;
			date.disabledDays = DISABLE_SUN_SAT;
		}
	}
}