package project.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2015-09-23 08:28:50")
/** */
public final class JournalMeta extends org.slim3.datastore.ModelMeta<project.model.Journal> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<project.model.Journal> UserKey = new org.slim3.datastore.StringAttributeMeta<project.model.Journal>(this, "UserKey", "UserKey");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.Journal, java.lang.Long> id = new org.slim3.datastore.CoreAttributeMeta<project.model.Journal, java.lang.Long>(this, "id", "id", long.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<project.model.Journal> journal_date = new org.slim3.datastore.StringAttributeMeta<project.model.Journal>(this, "journal_date", "journal_date");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.Journal, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<project.model.Journal, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<project.model.Journal, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<project.model.Journal, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final JournalMeta slim3_singleton = new JournalMeta();

    /**
     * @return the singleton
     */
    public static JournalMeta get() {
       return slim3_singleton;
    }

    /** */
    public JournalMeta() {
        super("Journal", project.model.Journal.class);
    }

    @Override
    public project.model.Journal entityToModel(com.google.appengine.api.datastore.Entity entity) {
        project.model.Journal model = new project.model.Journal();
        model.setUserKey((java.lang.String) entity.getProperty("UserKey"));
        model.setId(longToPrimitiveLong((java.lang.Long) entity.getProperty("id")));
        model.setJournal_date((java.lang.String) entity.getProperty("journal_date"));
        model.setKey(entity.getKey());
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        project.model.Journal m = (project.model.Journal) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("UserKey", m.getUserKey());
        entity.setProperty("id", m.getId());
        entity.setProperty("journal_date", m.getJournal_date());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        project.model.Journal m = (project.model.Journal) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        project.model.Journal m = (project.model.Journal) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        project.model.Journal m = (project.model.Journal) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        project.model.Journal m = (project.model.Journal) model;
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
        project.model.Journal m = (project.model.Journal) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getUserKey() != null){
            writer.setNextPropertyName("UserKey");
            encoder0.encode(writer, m.getUserKey());
        }
        writer.setNextPropertyName("id");
        encoder0.encode(writer, m.getId());
        if(m.getJournal_date() != null){
            writer.setNextPropertyName("journal_date");
            encoder0.encode(writer, m.getJournal_date());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected project.model.Journal jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        project.model.Journal m = new project.model.Journal();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("UserKey");
        m.setUserKey(decoder0.decode(reader, m.getUserKey()));
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("journal_date");
        m.setJournal_date(decoder0.decode(reader, m.getJournal_date()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}