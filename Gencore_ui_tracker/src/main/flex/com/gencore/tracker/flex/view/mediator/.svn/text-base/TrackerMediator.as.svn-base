package com.gencore.tracker.flex.view.mediator
{


    import com.gencore.commons.flex.model.MainModel;
    import com.gencore.commons.flex.vo.CourseVO;
    import com.gencore.tracker.flex.control.event.TrackerEvent;
    import com.gencore.tracker.flex.view.TrackerUI;
    
    import flash.utils.Dictionary;
    
    import mx.collections.ArrayCollection;
    
    import org.lucciframework.luccimvc.controller.event.LucciEventDispatcher;
    import org.lucciframework.luccimvc.view.mediator.Mediator;



	public class TrackerMediator extends Mediator
	{
		[Bindable]
		public var model:MainModel = MainModel.instance;
		
		[Bindable] public var courses : ArrayCollection;
		
		[Bindable] public var cycling_total : Number = 0;
		[Bindable] public var running_total : Number = 0;
		[Bindable] public var walking_total : Number = 0;
		
		private function onResult(trackerEvent:TrackerEvent):void
		{

			switch (trackerEvent.type)
			{
				case (TrackerEvent.GET_COURSES_ACK):
					
					LucciEventDispatcher.instance.removeEventListener(TrackerEvent.GET_COURSES_ACK, onResult);
					
					//(this.getViewComponent("trackerUI") as TrackerUI).courses = trackerEvent.data;
					
					courses = trackerEvent.data;
					
					calculateTotalForCourseType(courses);
					
					
					break;
				
				case (TrackerEvent.GET_COURSE_ACK):
					
					LucciEventDispatcher.instance.removeEventListener(TrackerEvent.GET_COURSE_ACK, onResult);
					
					(this.getViewComponent("trackerUI") as TrackerUI).currentCourse = trackerEvent.data;
					(this.getViewComponent("trackerUI") as TrackerUI).loadMaps();
					break;

			}
		}
		
		private function calculateTotalForCourseType ( courses:ArrayCollection) {
			
			for each ( var course : CourseVO in courses ) {
				
				if (course.courseType == '0') {
					
					cycling_total += course.distance;
					
				} else if (course.courseType == '1') {
					
					running_total +=  course.distance;
					
				} else if (course.courseType == '2') {
					
					walking_total += course.distance;
				}
			}
		}
		
		
		
		
		public function getCoursesOfUser():void
		{
			
			LucciEventDispatcher.instance.addEventListener(TrackerEvent.GET_COURSES_ACK, onResult);
			
			LucciEventDispatcher.instance.dispatchEvent(new TrackerEvent(TrackerEvent.GET_COURSES_EVENT,model.userConnected));
		}
		


		public function getCourseById(courseId:String):void {
			
			var data:Dictionary = new Dictionary();
			data["courseId"] = courseId;
			
			LucciEventDispatcher.instance.addEventListener(TrackerEvent.GET_COURSE_ACK, onResult);
			
			LucciEventDispatcher.instance.dispatchEvent(new TrackerEvent(TrackerEvent.GET_COURSE_EVENT,data));			
		}
		
		


	}
}