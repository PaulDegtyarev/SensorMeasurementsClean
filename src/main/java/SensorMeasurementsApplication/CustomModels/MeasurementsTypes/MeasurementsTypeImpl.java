package SensorMeasurementsApplication.CustomModels.MeasurementsTypes;

public class MeasurementsTypeImpl implements MeasurementsType{
    private String typeName;
    private String typeUnits;

    public MeasurementsTypeImpl(String typeName, String typeUnits) {
        this.typeName = typeName;
        this.typeUnits = typeUnits;
    }

    @Override
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String getTypeUnits() {
        return typeUnits;
    }

    public void setTypeUnits(String typeUnits) {
        this.typeUnits = typeUnits;
    }
}
