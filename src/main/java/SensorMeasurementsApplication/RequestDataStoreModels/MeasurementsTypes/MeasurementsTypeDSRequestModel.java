package SensorMeasurementsApplication.RequestDataStoreModels.MeasurementsTypes;

public class MeasurementsTypeDSRequestModel {
    private String typeName;
    private String typeUnits;

    public MeasurementsTypeDSRequestModel(String typeName, String typeUnits) {
        this.typeName = typeName;
        this.typeUnits = typeUnits;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeUnits() {
        return typeUnits;
    }

    public void setTypeUnits(String typeUnits) {
        this.typeUnits = typeUnits;
    }
}
