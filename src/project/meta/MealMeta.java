package project.meta;


//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2015-09-16 12:20:27")

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2015-09-17 17:40:19")
/** */
public final class MealMeta extends org.slim3.datastore.ModelMeta<project.model.Meal> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.Meal, java.lang.Integer> calories = new org.slim3.datastore.CoreAttributeMeta<project.model.Meal, java.lang.Integer>(this, "calories", "calories", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<project.model.Meal> category = new org.slim3.datastore.StringAttributeMeta<project.model.Meal>(this, "category", "category");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.Meal, java.lang.Integer> def_quantity = new org.slim3.datastore.CoreAttributeMeta<project.model.Meal, java.lang.Integer>(this, "def_quantity", "def_quantity", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<project.model.Meal> description = new org.slim3.datastore.StringAttributeMeta<project.model.Meal>(this, "description", "description");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.Meal, java.lang.Long> id = new org.slim3.datastore.CoreAttributeMeta<project.model.Meal, java.lang.Long>(this, "id", "id", long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.Meal, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<project.model.Meal, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<project.model.Meal> name = new org.slim3.datastore.StringAttributeMeta<project.model.Meal>(this, "name", "name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<project.model.Meal> picture = new org.slim3.datastore.StringAttributeMeta<project.model.Meal>(this, "picture", "picture");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<project.model.Meal> unit = new org.slim3.datastore.StringAttributeMeta<project.model.Meal>(this, "unit", "unit");

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
        model.setCategory((java.lang.String) entity.getProperty("category"));
        model.setDef_quantity(longToPrimitiveInt((java.lang.Long) entity.getProperty("def_quantity")));
        model.setDescription((java.lang.String) entity.getProperty("description"));
        model.setId(longToPrimitiveLong((java.lang.Long) entity.getProperty("id")));
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setPicture((java.lang.String) entity.getProperty("picture"));
        model.setUnit((java.lang.String) entity.getProperty("unit"));
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
        entity.setProperty("category", m.getCategory());
        entity.setProperty("def_quantity", m.getDef_quantity());
        entity.setProperty("description", m.getDescription());
        entity.setProperty("id", m.getId());
        entity.setProperty("name", m.getName());
        entity.setProperty("picture", m.getPicture());
        entity.setProperty("unit", m.getUnit());
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
        if(m.getCategory() != null){
            writer.setNextPropertyName("category");
            encoder0.encode(writer, m.getCategory());
        }
        writer.setNextPropertyName("def_quantity");
        encoder0.encode(writer, m.getDef_quantity());
        if(m.getDescription() != null){
            writer.setNextPropertyName("description");
            encoder0.encode(writer, m.getDescription());
        }
        writer.setNextPropertyName("id");
        encoder0.encode(writer, m.getId());
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
    protected project.model.Meal jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        project.model.Meal m = new project.model.Meal();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("calories");
        m.setCalories(decoder0.decode(reader, m.getCalories()));
        reader = rootReader.newObjectReader("category");
        m.setCategory(decoder0.decode(reader, m.getCategory()));
        reader = rootReader.newObjectReader("def_quantity");
        m.setDef_quantity(decoder0.decode(reader, m.getDef_quantity()));
        reader = rootReader.newObjectReader("description");
        m.setDescription(decoder0.decode(reader, m.getDescription()));
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
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