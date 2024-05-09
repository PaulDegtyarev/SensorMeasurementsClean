package SensorMeasurementsApplication.Responses.MeasurementsTypes;

import java.util.List;

public class MeasurementsTypeResponseModelGetAll {
    private List<MeasurementsTypeResponseModelPost> types;

    public MeasurementsTypeResponseModelGetAll(List<MeasurementsTypeResponseModelPost> types) {
        this.types = types;
    }

    public List<MeasurementsTypeResponseModelPost> getTypes() {
        return types;
    }

    public void setTypes(List<MeasurementsTypeResponseModelPost> types) {
        this.types = types;
    }
}
