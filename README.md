# TimeCategory
Java wrapper for Groovy's TimeCategory class

Apache Groovy's `TimeCategory` class makes working with dates a breeze.

```
  use (TimeCategory) {
    println 1.day.from.now
    println 5.weeks.ago
    println 30.seconds.from.now
    // etc...
  }
```

This super small library provides a Java wrapper to allow us to make similar calls in Java.

```
    import java.util.Date;
    import com.dustinredmond.groovytime.TimeCategory;
    
    public class Test {
        
        public static void main(String[] args) {
          Date yesterday = TimeCategory.of(1).day().ago();
          Date tomorrow = TimeCategory.of(1).day().from().today();
          Date nextYear = TimeCategory.of(52).weeks().from().today();
          Date nextWeek = TimeCategory.of(1).week().from().now();
        } 
    
    } 
```
