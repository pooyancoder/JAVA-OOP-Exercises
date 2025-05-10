# Sports Court Booking System 🏀

## Overview
This is a **Sports Court Booking System** built using **OOP principles in Java**. It allows users to book different types of sports courts based on availability.

## Features
- Different types of courts (e.g., basketball, tennis, football).
- Players can book courts if available.
- Admins can add/remove courts.

## Classes & Structure
```plaintext
SportsBookingSystem
 ├── Court
 ├── Player
 ├── Admin
 ├── Main (Runner)
```

## Implementation

### `Court.java`
```java
public class Court {
    private String sportType;
    private boolean isAvailable;

    public Court(String sportType) {
        this.sportType = sportType;
        this.isAvailable = true;
    }

    public boolean bookCourt() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    public void releaseCourt() {
        isAvailable = true;
    }

    public String getSportType() {
        return sportType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
```

### `Player.java`
```java
public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public boolean bookCourt(Court court) {
        if (court.bookCourt()) {
            System.out.println(name + " successfully booked a " + court.getSportType() + " court.");
            return true;
        }
        System.out.println("Court is already booked!");
        return false;
    }
}
```

### `Admin.java`
```java
import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Court> courts;

    public Admin() {
        this.courts = new ArrayList<>();
    }

    public void addCourt(Court court) {
        courts.add(court);
        System.out.println("Added " + court.getSportType() + " court.");
    }

    public List<Court> getCourts() {
        return courts;
    }
}
```

### `Main.java`
```java
public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Court basketballCourt = new Court("Basketball");
        Court tennisCourt = new Court("Tennis");
        
        admin.addCourt(basketballCourt);
        admin.addCourt(tennisCourt);
        
        Player player1 = new Player("John");
        Player player2 = new Player("Alice");
        
        player1.bookCourt(basketballCourt);
        player2.bookCourt(basketballCourt); // Should print "Court is already booked!"
    }
}
```

## How to Run
1. If you use new versions of java you can compile and run your code with this command in the terminal that is in your folder path:
   ```bash
   java fileName.java
   ```

## Future Enhancements
- Implement a booking schedule.
- Allow online booking with timestamps.
- Introduce payment system for reservations.

---
🏆 **Reserve your favorite court now!** 🎾
