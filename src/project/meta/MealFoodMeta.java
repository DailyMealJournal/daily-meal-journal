package project.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2015-07-21 01:04:24")
/** */
public final class MealFoodMeta extends org.slim3.datastore.ModelMeta<project.model.MealFood> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.MealFood, java.lang.Integer> foodKey = new org.slim3.datastore.CoreAttributeMeta<project.model.MealFood, java.lang.Integer>(this, "foodKey", "foodKey", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.MealFood, java.lang.Integer> foodQty = new org.slim3.datastore.CoreAttributeMeta<project.model.MealFood, java.lang.Integer>(this, "foodQty", "foodQty", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.MealFood, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<project.model.MealFood, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.MealFood, java.lang.Integer> mealKey = new org.slim3.datastore.CoreAttributeMeta<project.model.MealFood, java.lang.Integer>(this, "mealKey", "mealKey", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.MealFood, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<project.model.MealFood, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final MealFoodMeta slim3_singleton = new MealFoodMeta();

    /**
     * @return the singleton
     */
    public static MealFoodMeta get() {
       return slim3_singleton;
    }

    /** */
    public MealFoodMeta() {
        super("MealFood", project.model.MealFood.class);
    }

    @Override
    public project.model.MealFood entityToModel(com.google.appengine.api.datastore.Entity entity) {
        project.model.MealFood model = new project.model.MealFood();
        model.setFoodKey(longToPrimitiveInt((java.lang.Long) entity.getProperty("foodKey")));
        model.setFoodQty(longToPrimitiveInt((java.lang.Long) entity.getProperty("foodQty")));
        model.setKey(entity.getKey());
        model.setMealKey(longToPrimitiveInt((java.lang.Long) entity.getProperty("mealKey")));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        project.model.MealFood m = (project.model.MealFood) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("foodKey", m.getFoodKey());
        entity.setProperty("foodQty", m.getFoodQty());
        entity.setProperty("mealKey", m.getMealKey());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        project.model.MealFood m = (project.model.MealFood) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        project.model.MealFood m = (project.model.MealFood) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        project.model.MealFood m = (project.model.MealFood) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        project.model.MealFood m = (project.model.MealFood) model;
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
        project.model.MealFood m = (project.model.MealFood) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("foodKey");
        encoder0.encode(writer, m.getFoodKey());
        writer.setNextPropertyName("foodQty");
        encoder0.encode(writer, m.getFoodQty());
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        writer.setNextPropertyName("mealKey");
        encoder0.encode(writer, m.getMealKey());
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected project.model.MealFood jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        project.model.MealFood m = new project.model.MealFood();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("foodKey");
        m.setFoodKey(decoder0.decode(reader, m.getFoodKey()));
        reader = rootReader.newObjectReader("foodQty");
        m.setFoodQty(decoder0.decode(reader, m.getFoodQty()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("mealKey");
        m.setMealKey(decoder0.decode(reader, m.getMealKey()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}