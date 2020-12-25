# TimeCategory
Java wrapper for Groovy's TimeCategory class

Apache Groovy's `groovy.time.TimeCategory` class makes working with dates a breeze.

```
  use (TimeCategory) {
    println 1.day.from.now
    println 5.weeks.ago
    println 30.seconds.from.now
    // etc...
  }
```

This super small library provides a Java wrapper to allow us to make similar calls in Java.
We can get a `java.util.Date`, a `java.time.LocalDate`, or a `java.time.LocalDateTime`.

We can either use chained method calls, or pass in a String which will be interpreted
by Groovy. There is no advantage or disadvantage of using one over the other, but both
syntaxes are included for developer convenience.

```
    import java.util.Date;
    import com.dustinredmond.groovytime.TimeCategory;
    
    public class Test {
        
        public static void main(String[] args) {
          Date yesterday = TimeCategory.of(1).day().ago();
          Date tomorrow = TimeCategory.of(1).day().from().today();
          Date nextYear = TimeCategory.of(52).weeks().from().today();
          Date nextWeek = TimeCategory.of(1).week().from().now();

          LocalDate tomorrow = TimeCategory.of("1.day.from.now").getLocalDate();
          LocalDateTime aBitLater = TimeCategory.of("15.minutes.from.now").getLocalDateTime();
        } 
    
    } 
```

---

### How to download

The project is on Maven Central. Add the below in your POM.xml file to begin using the library.

```xml
<dependency>
    <groupId>com.dustinredmond.groovytime</groupId>
    <artifactId>TimeCategory</artifactId>
    <version>1.0.1</version>
</dependency>
```