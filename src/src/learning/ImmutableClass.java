package learning;

import java.util.HashMap;
import java.util.Map;

final  class ImmutableClass {
   public final String name;
   public final Map<String,String> metadata;
   public ImmutableClass(String name, Map<String,String> metaData) {
	   this.name = name;
	   Map<String,String> copyMap = new HashMap<String,String>();
	   for(Map.Entry<String, String> entry:metaData.entrySet()) {
		   copyMap.put(entry.getKey(), entry.getValue());
	   }
	   this.metadata=copyMap;
	  
	   
   }


}
