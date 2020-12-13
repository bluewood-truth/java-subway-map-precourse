package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import subway.utils.ValidationUtils;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    static {
        stations.add(new Station("교대역"));
        stations.add(new Station("강남역"));
        stations.add(new Station("역삼역"));
        stations.add(new Station("남부터미널역"));
        stations.add(new Station("양재역"));
        stations.add(new Station("양재시민의숲역"));
        stations.add(new Station("매봉역"));
    }

    public static void addStation(Station station) {
        ValidationUtils.validateDuplicatedStation(station.getName());

        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        ValidationUtils.validateDuplicatedStation(name);
        ValidationUtils.validateResisteredStation(name);

        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean containsStation(Station station) {
        return containsStation(station.getName());
    }
    
    public static boolean containsStation(String name) {
        return stations.stream().anyMatch(streamStation -> name.equals(streamStation.getName()));
    }
}
