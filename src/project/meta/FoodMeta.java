package project.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2015-07-21 01:04:24")
/** */
public final class FoodMeta extends org.slim3.datastore.ModelMeta<project.model.Food> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.Food, java.lang.Integer> calories = new org.slim3.datastore.CoreAttributeMeta<project.model.Food, java.lang.Integer>(this, "calories", "calories", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<project.model.Food> category = new org.slim3.datastore.StringAttributeMeta<project.model.Food>(this, "category", "category");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<project.model.Food> description = new org.slim3.datastore.StringAttributeMeta<project.model.Food>(this, "description", "description");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.Food, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<project.model.Food, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<project.model.Food> name = new org.slim3.datastore.StringAttributeMeta<project.model.Food>(this, "name", "name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<project.model.Food> picture = new org.slim3.datastore.StringAttributeMeta<project.model.Food>(this, "picture", "picture");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<project.model.Food> unit = new org.slim3.datastore.StringAttributeMeta<project.model.Food>(this, "unit", "unit");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.Food, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<project.model.Food, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final FoodMeta slim3_singleton = new FoodMeta();

    /**
     * @return the singleton
     */
    public static FoodMeta get() {
       return slim3_singleton;
    }

    /** */
    public FoodMeta() {
        super("Food", project.model.Food.class);
    }

    @Override
    public project.model.Food entityToModel(com.google.appengine.api.datastore.Entity entity) {
        project.model.Food model = new project.model.Food();
        model.setCalories(longToPrimitiveInt((java.lang.Long) entity.getProperty("calories")));
        model.setCategory((java.lang.String) entity.getProperty("category"));
        model.setDescription((java.lang.String) entity.getProperty("description"));
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setPicture((java.lang.String) entity.getProperty("picture"));
        model.setUnit((java.lang.String) entity.getProperty("unit"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        project.model.Food m = (project.model.Food) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("calories", m.getCalories());
        entity.setProperty("category", m.getCategory());
        entity.setProperty("description", m.getDescription());
        entity.setProperty("name", m.getName());
        entity.setProperty("picture", m.getPicture());
        entity.setProperty("unit", m.getUnit());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        project.model.Food m = (project.model.Food) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        project.model.Food m = (project.model.Food) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        project.model.Food m = (project.model.Food) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        project.model.Food m = (project.model.Food) model;
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
        project.model.Food m = (project.model.Food) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("calories");
        encoder0.encode(writer, m.getCalories());
        if(m.getCategory() != null){
            writer.setNextPropertyName("category");
            encoder0.encode(writer, m.getCategory());
        }
        if(m.getDescription() != null){
            writer.setNextPropertyName("description");
            encoder0.encode(writer, m.getDescription());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder0.encode(writer, m.getName());
        }
        if(m.getPicture() != null){
            writer.setNextPropertyName("picture");
            encoder0.encode(writer, m.getPicture());
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
    protected project.model.Food jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        project.model.Food m = new project.model.Food();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("calories");
        m.setCalories(decoder0.decode(reader, m.getCalories()));
        reader = rootReader.newObjectReader("category");
        m.setCategory(decoder0.decode(reader, m.getCategory()));
        reader = rootReader.newObjectReader("description");
        m.setDescription(decoder0.decode(reader, m.getDescription()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("picture");
        m.setPicture(decoder0.decode(reader, m.getPicture()));
        reader = rootReader.newObjectReader("unit");
        m.setUnit(decoder0.decode(reader, m.getUnit()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}