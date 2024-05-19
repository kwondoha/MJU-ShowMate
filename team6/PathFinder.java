package team6;

import java.time.DateTimeException;
import java.util.Map;
import java.util.HashMap;

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
        return new Path(); // 실제 경로 반환
    }
}

class BusAlgorithm implements PathAlgorithm {
    @Override
    public Path findpath(Location start, Location end) {
        return new Path(); // 실제 경로 반환
    }
}

class MixedAlgorithm implements PathAlgorithm {
    @Override
    public Path findpath(Location start, Location end) {
        return new Path(); // 실제 경로 반환
    }
}

class SubwayAlgorithm implements PathAlgorithm {
    @Override
    public Path findpath(Location start, Location end) {
        return new Path(); // 실제 경로 반환
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

class GPS {
    public Location getCurrentLocation() {
        // 실제 구현에서는 GPS 모듈에서 현재 위치를 가져오는 로직이 필요합니다.
        return new Location();
    }
}