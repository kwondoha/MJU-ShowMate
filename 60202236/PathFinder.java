import java.time.LocalDateTime;
import java.util.Map;
import java.util.HashMap;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import androidx.core.app.ActivityCompat;


abstract class PathFinder {
    private Location currentLocation;
    private Location eventLocation;

    abstract PathAlgorithm createAlgorithm();
}

class WalkingPathFinder extends PathFinder {
    @Override
    PathAlgorithm createAlgorithm() {
        return new WalkingAlgorithm();
    }
}

class BusPathFinder extends PathFinder {
    @Override
    PathAlgorithm createAlgorithm() {
        return new BusAlgorithm();
    }
}

class MixedPathFinder extends PathFinder {
    @Override
    PathAlgorithm createAlgorithm() {
        return new MixedAlgorithm();
    }
}

class SubwayPathFinder extends PathFinder {
    @Override
    PathAlgorithm createAlgorithm() {
        return new SubwayAlgorithm();
    }
}

interface PathAlgorithm {
    Path findpath(Location start, Location end);
}

class WalkingAlgorithm implements PathAlgorithm {
    @Override
    public Path findpath(Location start, Location end) {
        double distance = calculateDistance(start, end); // 직선 거리 계산
        double walkingSpeed = 5.0; // km/h 가정
        double timeInHours = distance / walkingSpeed;
        LocalDateTime arrivalTime = LocalDateTime.now().plusMinutes((long) (timeInHours * 60));
        return new Path("Walking path from " + start.getName() + " to " + end.getName(), arrivalTime);
    }

    private double calculateDistance(Location start, Location end) {
        double lat1 = start.getLatitude();
        double lon1 = start.getLongitude();
        double lat2 = end.getLatitude();
        double lon2 = end.getLongitude();
        double earthRadius = 6371; // km

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;

        return distance;
    }
}

class BusAlgorithm implements PathAlgorithm {
    @Override
    public Path findpath(Location start, Location end) {
        double distance = calculateDistance(start, end); // 직선 거리 계산
        double busSpeed = 40.0; // km/h 가정
        double timeInHours = distance / busSpeed;
        LocalDateTime arrivalTime = LocalDateTime.now().plusMinutes((long) (timeInHours * 60));
        return new Path("Bus path from " + start.getName() + " to " + end.getName(), arrivalTime);
    }

    private double calculateDistance(Location start, Location end) {
        double lat1 = start.getLatitude();
        double lon1 = start.getLongitude();
        double lat2 = end.getLatitude();
        double lon2 = end.getLongitude();
        double earthRadius = 6371; // km

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;

        return distance;
    }
}

class MixedAlgorithm implements PathAlgorithm {
    @Override
    public Path findpath(Location start, Location end) {
        double walkingDistance = 0.5; // 걷는 거리 0.5km 가정
        double walkingSpeed = 5.0; // km/h
        double busSpeed = 40.0; // km/h

        double totalDistance = calculateDistance(start, end);
        double busDistance = totalDistance - walkingDistance;

        double walkingTimeInHours = walkingDistance / walkingSpeed;
        double busTimeInHours = busDistance / busSpeed;

        double totalTimeInHours = walkingTimeInHours + busTimeInHours;
        LocalDateTime arrivalTime = LocalDateTime.now().plusMinutes((long) (totalTimeInHours * 60));

        return new Path("Mixed path (walk + bus) from " + start.getName() + " to " + end.getName(), arrivalTime);
    }

    private double calculateDistance(Location start, Location end) {
        double lat1 = start.getLatitude();
        double lon1 = start.getLongitude();
        double lat2 = end.getLatitude();
        double lon2 = end.getLongitude();
        double earthRadius = 6371; // km

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;

        return distance;
    }
}

class SubwayAlgorithm implements PathAlgorithm {
    @Override
    public Path findpath(Location start, Location end) {
        double distance = calculateDistance(start, end); // 직선 거리 계산
        double subwaySpeed = 60.0; // km/h 가정
        double timeInHours = distance / subwaySpeed;
        LocalDateTime arrivalTime = LocalDateTime.now().plusMinutes((long) (timeInHours * 60));
        return new Path("Subway path from " + start.getName() + " to " + end.getName(), arrivalTime);
    }

    private double calculateDistance(Location start, Location end) {
        double lat1 = start.getLatitude();
        double lon1 = start.getLongitude();
        double lat2 = end.getLatitude();
        double lon2 = end.getLongitude();
        double earthRadius = 6371; // km

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;

        return distance;
    }
}

class Path {
    private String pathInfo;
    private DateTimeException arrivalTime;

    public Path displayPath(){
        return null;
    }
}

class Location {
    private String name;
    private float latitude;
    private float longitude;

    public Location() {}

    public Location(String name, float latitude, float longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}

class LocationFlyweight extends Location{
    private String name;
    private float latitude;
    private float longitude;

    public LocationFlyweight(String name, float latitude, float longitude) {
}
}

class LocationFactory {
    private Map<String, LocationFlyweight> locationPool = new HashMap<>();

    public LocationFlyweight getSharedLocation(String name){
        return null;
    }
}

public class GPS {
    private Context context;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private Location currentLocation;

    public GPS(Context context) {
        this.context = context;
        this.locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        this.currentLocation = new Location("default", 0.0f, 0.0f);
    }

    public Location getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // 권한 요청 로직 필요
            return currentLocation;
        }

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(android.location.Location location) {
                currentLocation.setLatitude((float) location.getLatitude());
                currentLocation.setLongitude((float) location.getLongitude());
            }

            @Override
            public void onStatusChanged(String provider, int status, android.os.Bundle extras) {
            }

            @Override
            public void onProviderEnabled(String provider) {
            }

            @Override
            public void onProviderDisabled(String provider) {
            }
        };

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        return currentLocation;
    }
