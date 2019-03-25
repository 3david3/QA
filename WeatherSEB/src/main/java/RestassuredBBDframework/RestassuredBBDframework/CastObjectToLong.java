package RestassuredBBDframework.RestassuredBBDframework;
	
	public class CastObjectToLong {
	    public static Long castLongObject(Object object) {
	        Long result = 0l;
	        try {
	            if (object instanceof Long)
	                result = ((Long) object).longValue();
	            else if (object instanceof Integer) {
	                result = ((Integer) object).longValue();
	            } 
	            System.out.println(result);
	        } catch (Exception e) {
	            System.out.println("cannot cast");
	            
	        }
	        return result;
	    }

	    @SuppressWarnings("static-access")
		public static void main(String... args) {
	        CastObjectToLong castObjectToLong = new CastObjectToLong();
	        Object object1 = Response_rest.sunrise; // Object
	      
	        castObjectToLong.castLongObject(object1);    
	    }
}
