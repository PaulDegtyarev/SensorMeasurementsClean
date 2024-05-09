package SensorMeasurementsApplication.ResponseDataStoreModels.Sensors;

public class SensorsDSResponseGetTypes {
    private Integer typeId;
    private String typeName;
    private String typeUnits;
    private String typeFormula;

    public SensorsDSResponseGetTypes(Integer typeId, String typeName, String typeUnits, String typeFormula) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.typeUnits = typeUnits;
        this.typeFormula = typeFormula;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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

    public String getTypeFormula() {
        return typeFormula;
    }

    public void setTypeFormula(String typeFormula) {
        this.typeFormula = typeFormula;
    }
}
