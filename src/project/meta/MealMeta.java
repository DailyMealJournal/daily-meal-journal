package project.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2015-07-29 08:27:38")

/** */
public final class MealMeta extends org.slim3.datastore.ModelMeta<project.model.Meal> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.Meal, java.lang.Integer> calories = new org.slim3.datastore.CoreAttributeMeta<project.model.Meal, java.lang.Integer>(this, "calories", "calories", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<project.model.Meal> description = new org.slim3.datastore.StringAttributeMeta<project.model.Meal>(this, "description", "description");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.Meal, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<project.model.Meal, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<project.model.Meal> name = new org.slim3.datastore.StringAttributeMeta<project.model.Meal>(this, "name", "name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<project.model.Meal> picture = new org.slim3.datastore.StringAttributeMeta<project.model.Meal>(this, "picture", "picture");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<project.model.Meal> tags = new org.slim3.datastore.StringAttributeMeta<project.model.Meal>(this, "tags", "tags");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<project.model.Meal> unit = new org.slim3.datastore.StringAttributeMeta<project.model.Meal>(this, "unit", "unit");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.Meal, java.lang.Integer> userKey = new org.slim3.datastore.CoreAttributeMeta<project.model.Meal, java.lang.Integer>(this, "userKey", "userKey", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.Meal, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<project.model.Meal, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final MealMeta slim3_singleton = new MealMeta();

    /**
     * @return the singleton
     */
    public static MealMeta get() {
       return slim3_singleton;
    }

    /** */
    public MealMeta() {
        super("Meal", project.model.Meal.class);
    }

    @Override
    public project.model.Meal entityToModel(com.google.appengine.api.datastore.Entity entity) {
        project.model.Meal model = new project.model.Meal();
        model.setCalories(longToPrimitiveInt((java.lang.Long) entity.getProperty("calories")));
        model.setDescription((java.lang.String) entity.getProperty("description"));
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setPicture((java.lang.String) entity.getProperty("picture"));
        model.setTags((java.lang.String) entity.getProperty("tags"));
        model.setUnit((java.lang.String) entity.getProperty("unit"));
        model.setUserKey(longToPrimitiveInt((java.lang.Long) entity.getProperty("userKey")));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        project.model.Meal m = (project.model.Meal) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("calories", m.getCalories());
        entity.setProperty("description", m.getDescription());
        entity.setProperty("name", m.getName());
        entity.setProperty("picture", m.getPicture());
        entity.setProperty("tags", m.getTags());
        entity.setProperty("unit", m.getUnit());
        entity.setProperty("userKey", m.getUserKey());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        project.model.Meal m = (project.model.Meal) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        project.model.Meal m = (project.model.Meal) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        project.model.Meal m = (project.model.Meal) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        project.model.Meal m = (project.model.Meal) model;
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
        project.model.Meal m = (project.model.Meal) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("calories");
        encoder0.encode(writer, m.getCalories());
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
        if(m.getTags() != null){
            writer.setNextPropertyName("tags");
            encoder0.encode(writer, m.getTags());
        }
        if(m.getUnit() != null){
            writer.setNextPropertyName("unit");
            encoder0.encode(writer, m.getUnit());
        }
        writer.setNextPropertyName("userKey");
        encoder0.encode(writer, m.getUserKey());
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected project.model.Meal jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        project.model.Meal m = new project.model.Meal();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("calories");
        m.setCalories(decoder0.decode(reader, m.getCalories()));
        reader = rootReader.newObjectReader("description");
        m.setDescription(decoder0.decode(reader, m.getDescription()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("picture");
        m.setPicture(decoder0.decode(reader, m.getPicture()));
        reader = rootReader.newObjectReader("tags");
        m.setTags(decoder0.decode(reader, m.getTags()));
        reader = rootReader.newObjectReader("unit");
        m.setUnit(decoder0.decode(reader, m.getUnit()));
        reader = rootReader.newObjectReader("userKey");
        m.setUserKey(decoder0.decode(reader, m.getUserKey()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}