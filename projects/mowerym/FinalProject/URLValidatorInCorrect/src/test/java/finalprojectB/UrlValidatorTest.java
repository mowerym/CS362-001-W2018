
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing
      //You can use this function to implement your manual testing

      System.out.println("MTest1: should be valid");
      UrlValidator urlValidator = new UrlValidator();
      if (urlValidator.isValid("ftp://foo.bar.com/")) {
         System.out.println("url is valid");
      } else {
         System.out.println("url is invalid");
      }

      System.out.println("MTest2: should be invalid");
      String[] schemes = {"http","https"};
      UrlValidator urlValidator2 = new UrlValidator(schemes);
      if (urlValidator2.isValid("ftp://foo.bar.com/")) {
         System.out.println("url is valid");
      } else {
         System.out.println("url is invalid");
      }

      System.out.println("MTest3: should be valid");
      UrlValidator urlValidator3 = new UrlValidator();
      if (urlValidator3.isValid("ftp://billgates:moremoney@files.microsoft.com/special/secretplans")) {
         System.out.println("url is valid");
      } else {
         System.out.println("url is invalid");
      }

      System.out.println("MTest4: should be invalid");
      UrlValidator urlValidator4 = new UrlValidator(schemes);
      if (urlValidator4.isValid("ftp://billgates:moremoney@files.microsoft.com/special/secretplans")) {
         System.out.println("url is valid");
      } else {
         System.out.println("url is invalid");
      }

      System.out.println("MTest5: should be valid");
      UrlValidator urlValidator5 = new UrlValidator(schemes);
      if (urlValidator5.isValid("https://google.com")) {
         System.out.println("url is valid");
      } else {
         System.out.println("url is invalid");
      }

      System.out.println("MTest6: should be valid");
      UrlValidator urlValidator6 = new UrlValidator(schemes);
      if (urlValidator6.isValid("https://drive.google.com/")) {
         System.out.println("url is valid");
      } else {
         System.out.println("url is invalid");
      }
      System.out.println("_______________________________________________");
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing
   // partition test the schemes
      // true schemes - http://, ftp://, h3t://,""
      // false schemes - 3ht://, http:/, http:, ://
      System.out.println("Scheme testing\n");
      System.out.println("Should be true:");
      System.out.println("http://");
      System.out.println("ftp://");
      System.out.println("h3t://");
      System.out.println(" ");
      System.out.println("Should be false:");
      System.out.println("3ht://");
      System.out.println("http:/");
      System.out.println("http:");
      System.out.println("http/");
      System.out.println("://\n");
      String[] test = {"http://", "ftp://", "h3t://", " ","3ht://", "http:/", "http:", "http/", "://"};
      int size = test.length;
      UrlValidator urlVal = new UrlValidator(test);
      System.out.println("Begin tests:");
      for(int i = 0; i< size; i++)
      {
         System.out.println(test[i]);
         if(urlVal.isValidScheme(test[i]))
         {
            System.out.println("true");
         }
         else
         {
            System.out.println("false");
         }
      }
      System.out.println("End tests.");
   System.out.println("__________________________________________________");
   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   
      // authority testing
      // true authorities
      // www.google.com, go.com, foo.bar.com
      // false authorities
      // go.a, 1.2.3, aaa
      System.out.println("Authority testing\n");
      System.out.println("Should be true:");
      System.out.println("www.google.com");
      System.out.println("go.com");
      System.out.println("foo.bar.com");
      System.out.println(" ");
      System.out.println("Should be false:");
      System.out.println("go.a");
      System.out.println("1.2.3");
      System.out.println("aaa\n");
      String[] test2 = {"www.google.com", "go.com", "foo.bar.com", "go.a", "1.2.3", "aaa"};
      int size2 = test2.length;
      UrlValidator urlVal2 = new UrlValidator(test2);
      System.out.println("Begin tests:");
      for(int i = 0; i< size2; i++)
      {
         System.out.println(test2[i]);
         if(urlVal2.isValidAuthority(test2[i]))
         {
            System.out.println("true");
         }
         else
         {
            System.out.println("false");
         }
      }
      System.out.println("End tests.");
      System.out.println("_______________________________________________");
   }
   //You need to create more test cases for your Partitions if you need to
   public void testYourThirdPartition()
   {
      //You can use this function to implement your First Partition testing
      // partition test the paths
      // true paths - /test1, /t123, /
      // false paths - /.., /../, /#
      System.out.println("Path testing\n");
      System.out.println("Should be true:");
      System.out.println("/test1");
      System.out.println("/t123");
      System.out.println("/");
      System.out.println(" ");
      System.out.println("Should be false:");
      System.out.println("/..");
      System.out.println("/../");
      System.out.println("/#\n");
      String[] test3 = {"/test1", "/t123", "/", "/..","/../", "/#"};
      int size3 = test3.length;
      UrlValidator urlVal3 = new UrlValidator(test3);
      System.out.println("Begin tests:");
      for(int i = 0; i< size3; i++)
      {
         System.out.println(test3[i]);
         if(urlVal3.isValidPath(test3[i]))
         {
            System.out.println("true");
         }
         else
         {
            System.out.println("false");
         }
      }
      System.out.println("End tests.");
      System.out.println("_______________________________________________");
   }

   public void testYourFourthPartition()
   {
      //You can use this function to implement your First Partition testing
      // partition test the query
      // true query - ?action=view, " "
      // false query - ?action, fail
      System.out.println("Query testing\n");
      System.out.println("Should be true:");
      System.out.println("?action=view");
      System.out.println(" ");
      System.out.println(" ");
      System.out.println("Should be false:");
      System.out.println("shouldBeFalse");
      System.out.println("fail\n");
      String[] test4 = {"?action=view", "", "shouldBeFalse", "fail"};
      int size4 = test4.length;
      UrlValidator urlVal4 = new UrlValidator(test4);
      System.out.println("Begin tests:");
      for(int i = 0; i< size4; i++)
      {
         System.out.println(test4[i]);
         if(urlVal4.isValidQuery(test4[i]))
         {
            System.out.println("true");
         }
         else
         {
            System.out.println("false");
         }
      }
      System.out.println("End tests.");
      System.out.println("_______________________________________________");
   }

   public void testIsValid()
   {
	   //You can use this function for programming based testing
	   System.out.println("Programming Based Testing Begins: \n");
       UrlValidator urlValidator = new UrlValidator();

       String[] test = {"http://", "ftp://", "h3t://", " ","3ht://", "http:/", "http:", "http/", "://"};
       String[] test2 = {"www.google.com", "go.com", "foo.bar.com", "go.a", "1.2.3", "aaa"};
       String[] test3 = {"/test1", "/t123", "/", "/..","/../", "/#"};
       String[] test4 = {"?action=view", "", "shouldBeFalse", "fail"};

       for(int a = 0; a < test.length; a++){
           for(int b = 0; b < test2.length;b++){
               for(int c = 0; c < test3.length;c++){
                   for(int d = 0; d < test4.length;d++){
                       String urlTest = test[a]+test2[b]+test3[c]+test4[d];
                       if(urlValidator.isValid(urlTest)){
                           System.out.println("Test string: " + urlTest + " is valid");
                       }
                       else{
                           System.out.println("Test string: " + urlTest + " is invalid");
                       }
                   }
               }
           }
       }

   }
   


}
