package SensorMeasurementsApplication.RequestDataStoreModels.Measurements;

import SensorMeasurementsApplication.CustomModels.Measurements.Measurements;

import java.util.List;

public class MeasurementsDSRequesModel {
    private List<Measurements> measurements;

    public MeasurementsDSRequesModel(List<Measurements> measurements) {
        this.measurements = measurements;
    }

    public List<Measurements> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurements> measurements) {
        this.measurements = measurements;
    }
}
