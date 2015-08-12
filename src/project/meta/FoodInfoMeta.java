package project.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2015-08-11 07:08:24")
/** */
public final class FoodInfoMeta extends org.slim3.datastore.ModelMeta<project.model.FoodInfo> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.FoodInfo, java.lang.Integer> calories = new org.slim3.datastore.CoreAttributeMeta<project.model.FoodInfo, java.lang.Integer>(this, "calories", "calories", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.FoodInfo, com.google.appengine.api.datastore.Key> foodKey = new org.slim3.datastore.CoreAttributeMeta<project.model.FoodInfo, com.google.appengine.api.datastore.Key>(this, "foodKey", "foodKey", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.FoodInfo, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<project.model.FoodInfo, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<project.model.FoodInfo> unit = new org.slim3.datastore.StringAttributeMeta<project.model.FoodInfo>(this, "unit", "unit");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.FoodInfo, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<project.model.FoodInfo, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final FoodInfoMeta slim3_singleton = new FoodInfoMeta();

    /**
     * @return the singleton
     */
    public static FoodInfoMeta get() {
       return slim3_singleton;
    }

    /** */
    public FoodInfoMeta() {
        super("FoodInfo", project.model.FoodInfo.class);
    }

    @Override
    public project.model.FoodInfo entityToModel(com.google.appengine.api.datastore.Entity entity) {
        project.model.FoodInfo model = new project.model.FoodInfo();
        model.setCalories(longToPrimitiveInt((java.lang.Long) entity.getProperty("calories")));
        model.setFoodKey((com.google.appengine.api.datastore.Key) entity.getProperty("foodKey"));
        model.setKey(entity.getKey());
        model.setUnit((java.lang.String) entity.getProperty("unit"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        project.model.FoodInfo m = (project.model.FoodInfo) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("calories", m.getCalories());
        entity.setProperty("foodKey", m.getFoodKey());
        entity.setProperty("unit", m.getUnit());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        project.model.FoodInfo m = (project.model.FoodInfo) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        project.model.FoodInfo m = (project.model.FoodInfo) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        project.model.FoodInfo m = (project.model.FoodInfo) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        project.model.FoodInfo m = (project.model.FoodInfo) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        project.model.FoodInfo m = (project.model.FoodInfo) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("calories");
        encoder0.encode(writer, m.getCalories());
        if(m.getFoodKey() != null){
            writer.setNextPropertyName("foodKey");
            encoder0.encode(writer, m.getFoodKey());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getUnit() != null){
            writer.setNextPropertyName("unit");
            encoder0.encode(writer, m.getUnit());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected project.model.FoodInfo jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        project.model.FoodInfo m = new project.model.FoodInfo();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("calories");
        m.setCalories(decoder0.decode(reader, m.getCalories()));
        reader = rootReader.newObjectReader("foodKey");
        m.setFoodKey(decoder0.decode(reader, m.getFoodKey()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("unit");
        m.setUnit(decoder0.decode(reader, m.getUnit()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}