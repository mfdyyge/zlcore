package ojdbc;

import java.sql.*;


import oracle.jdbc.OracleSavepoint;

import oracle.jdbc.aq.*;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPTZ;
import oracle.sql.TypeDescriptor;

import java.sql.Date;

import java.util.*;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.concurrent.Executor;

/**
 * A simple implementation of a connection wrapper which may be nested to any depth.
 */

public class OracleConnectionWrapper implements oracle.jdbc.OracleConnection {
  protected oracle.jdbc.OracleConnection connection;

  public OracleConnectionWrapper() {
  }

  /**
   * Construct an instance which wraps the arguement
   *
   * @param toBeWrapped
   */
  public OracleConnectionWrapper(oracle.jdbc.OracleConnection toBeWrapped) {
    super();

    connection = toBeWrapped;

    toBeWrapped.setWrapper((oracle.jdbc.OracleConnection) this);
  }

  /**
   * Unwrap one level.
   * Returns the connection within this wrapper.
   *
   * @return
   */
  public oracle.jdbc.OracleConnection unwrap() {
    return connection;
  }


  // perhaps temporary gateway to the above while newdriver is distinct
  // from driver
  public oracle.jdbc.internal.OracleConnection physicalConnectionWithin() {
    return connection.physicalConnectionWithin();
  }

  /**
   * Returns the database timezone.
   */
  public String getDatabaseTimeZone() throws SQLException {
    return physicalConnectionWithin().getDatabaseTimeZone();
  }


  /**
   * Set a connection wrapper as the wrapper of this connection.
   * Recursively sets the wrapper to the lowest level.
   * Thus the physical connection will always know its outermost wrapper
   * The recursion is terminated by the method in oracle.jdbc.driver.OracleConnction
   * which stores its argument.
   *
   * @param wrapper
   * @ See the methods getJavaSqlConnection and getOracleConnection
   * @ in oracle.jdbc.driver.OracleConnection
   */
  public void setWrapper(oracle.jdbc.OracleConnection wrapper) {
    connection.setWrapper(wrapper);
  }

  /* override methods in Object to forward them */

  // none at present

  /* implement java.sql.Connection */

  public Statement createStatement() throws SQLException {
    return connection.createStatement();
  }

  public PreparedStatement prepareStatement(String sql) throws SQLException {
    return connection.prepareStatement(sql);
  }

  public CallableStatement prepareCall(String sql) throws SQLException {
    return connection.prepareCall(sql);
  }

  public String nativeSQL(String sql) throws SQLException {
    return connection.nativeSQL(sql);
  }

  public void setAutoCommit(boolean autoCommit) throws SQLException {
    connection.setAutoCommit(autoCommit);
  }

  public boolean getAutoCommit() throws SQLException {
    return connection.getAutoCommit();
  }

  public void commit() throws SQLException {
    connection.commit();
  }

  public void rollback() throws SQLException {
    connection.rollback();
  }

  public void close() throws SQLException {
    connection.close();
  }

  public boolean isClosed() throws SQLException {
    return connection.isClosed();
  }

  public DatabaseMetaData getMetaData() throws SQLException {
    return connection.getMetaData();
  }

  public void setReadOnly(boolean readOnly) throws SQLException {
    connection.setReadOnly(readOnly);
  }

  public boolean isReadOnly() throws SQLException {
    return connection.isReadOnly();
  }

  public void setCatalog(String catalog) throws SQLException {
    connection.setCatalog(catalog);
  }

  public String getCatalog() throws SQLException {
    return connection.getCatalog();
  }

  public void setTransactionIsolation(int level) throws SQLException {
    connection.setTransactionIsolation(level);
  }

  public int getTransactionIsolation() throws SQLException {
    return connection.getTransactionIsolation();
  }

  public SQLWarning getWarnings() throws SQLException {
    return connection.getWarnings();
  }

  public void clearWarnings() throws SQLException {
    connection.clearWarnings();
  }

  public Statement createStatement(int resultSetType,
                                   int resultSetConcurrency) throws SQLException {
    return connection.createStatement(resultSetType, resultSetConcurrency);
  }

  public PreparedStatement prepareStatement(String sql, int resultSetType,
                                            int resultSetConcurrency) throws SQLException {
    return connection.prepareStatement(sql, resultSetType,
            resultSetConcurrency);
  }

  public CallableStatement prepareCall(String sql, int resultSetType,
                                       int resultSetConcurrency) throws SQLException {
    return connection.prepareCall(sql, resultSetType, resultSetConcurrency);
  }

  public java.util.Map getTypeMap() throws SQLException {
    return connection.getTypeMap();
  }

  public void setTypeMap(java.util.Map map) throws SQLException {
    connection.setTypeMap(map);
  }


  /* implement oracle.jdbc.OracleConnection methods */
  public boolean isProxySession() {
    return connection.isProxySession();
  }

  public void openProxySession(int mode,
                               java.util.Properties prop) throws SQLException {
    connection.openProxySession(mode, prop);
  }

  @Override
  public void commit(EnumSet<CommitOption> enumSet) throws SQLException {

  }

  public void archive(int mode, int aseq, String acstext) throws SQLException {
    connection.archive(mode, aseq, acstext);
  }

  public boolean getAutoClose() throws SQLException {
    return connection.getAutoClose();
  }

  public CallableStatement getCallWithKey(String key) throws SQLException {
    return connection.getCallWithKey(key);
  }

  public int getDefaultExecuteBatch() {
    return connection.getDefaultExecuteBatch();
  }

  public int getDefaultRowPrefetch() {
    return connection.getDefaultRowPrefetch();
  }

  public Object getDescriptor(String sql_name) {
    return connection.getDescriptor(sql_name);
  }

  public String[] getEndToEndMetrics() throws SQLException {
    return connection.getEndToEndMetrics();
  }

  public short getEndToEndECIDSequenceNumber() throws SQLException {
    return connection.getEndToEndECIDSequenceNumber();
  }

  public boolean getIncludeSynonyms() {
    return connection.getIncludeSynonyms();
  }

  public boolean getRestrictGetTables() {
    return connection.getRestrictGetTables();
  }

  public boolean getImplicitCachingEnabled() throws SQLException {
    return connection.getImplicitCachingEnabled();
  }

  public boolean getExplicitCachingEnabled() throws SQLException {
    return connection.getExplicitCachingEnabled();
  }


  public Object getJavaObject(String sql_name) throws SQLException {
    return connection.getJavaObject(sql_name);
  }

  public boolean getRemarksReporting() {
    return connection.getRemarksReporting();
  }

  public String getSQLType(Object obj) throws SQLException {
    return connection.getSQLType(obj);
  }

  public int getStmtCacheSize() {
    return connection.getStmtCacheSize();
  }

  public int getStatementCacheSize() throws SQLException {
    return connection.getStatementCacheSize();
  }

  public PreparedStatement getStatementWithKey(String key) throws SQLException {
    return connection.getStatementWithKey(key);
  }

  public short getStructAttrCsId() throws SQLException {
    return connection.getStructAttrCsId();
  }

  public String getUserName() throws SQLException {
    return connection.getUserName();
  }

  public String getCurrentSchema() throws SQLException {
    return connection.getCurrentSchema();
  }

  public boolean getUsingXAFlag() {
    return connection.getUsingXAFlag();
  }

  public boolean getXAErrorFlag() {
    return connection.getXAErrorFlag();
  }

  public OracleSavepoint oracleSetSavepoint() throws SQLException {
    return connection.oracleSetSavepoint();
  }

  public OracleSavepoint oracleSetSavepoint(String name) throws SQLException {
    return connection.oracleSetSavepoint(name);
  }

  public void oracleRollback(OracleSavepoint savepoint) throws SQLException {
    connection.oracleRollback(savepoint);
  }

  public void oracleReleaseSavepoint(OracleSavepoint savepoint)
          throws SQLException {
    connection.oracleReleaseSavepoint(savepoint);
  }


  public int pingDatabase() throws SQLException {
    return connection.pingDatabase();
  }

  public int pingDatabase(int timeOut) throws SQLException {
    return connection.pingDatabase(timeOut);
  }

  public void purgeExplicitCache() throws SQLException {
    connection.purgeExplicitCache();
  }

  public void purgeImplicitCache() throws SQLException {
    connection.purgeImplicitCache();
  }

  public void putDescriptor(String sql_name, Object desc) throws SQLException {
    connection.putDescriptor(sql_name, desc);
  }

  public void registerSQLType(String sql_name,
                              Class java_class) throws SQLException {
    connection.registerSQLType(sql_name, java_class);
  }

  public void registerSQLType(String sql_name,
                              String java_class_name) throws SQLException {
    connection.registerSQLType(sql_name, java_class_name);
  }

  public void setAutoClose(boolean autoClose) throws SQLException {
    connection.setAutoClose(autoClose);
  }

  public void setDefaultExecuteBatch(int batch) throws SQLException {
    connection.setDefaultExecuteBatch(batch);
  }

  public void setDefaultRowPrefetch(int value) throws SQLException {
    connection.setDefaultRowPrefetch(value);
  }

  public void setEndToEndMetrics(String[] metrics,
                                 short sequenceNumber) throws SQLException {
    connection.setEndToEndMetrics(metrics, sequenceNumber);
  }

  public void setExplicitCachingEnabled(boolean cache) throws SQLException {
    connection.setExplicitCachingEnabled(cache);
  }

  public void setImplicitCachingEnabled(boolean cache) throws SQLException {
    connection.setImplicitCachingEnabled(cache);
  }

  public void setIncludeSynonyms(boolean synonyms) {
    connection.setIncludeSynonyms(synonyms);
  }

  public void setRemarksReporting(boolean reportRemarks) {
    connection.setRemarksReporting(reportRemarks);
  }

  public void setRestrictGetTables(boolean restrict) {
    connection.setRestrictGetTables(restrict);
  }

  public void setStmtCacheSize(int size) throws SQLException {
    connection.setStmtCacheSize(size);
  }

  public void setStatementCacheSize(int size) throws SQLException {
    connection.setStatementCacheSize(size);
  }

  public void setStmtCacheSize(int size,
                               boolean clearMetaData) throws SQLException {
    connection.setStmtCacheSize(size, clearMetaData);
  }

  public void setUsingXAFlag(boolean value) {
    connection.setUsingXAFlag(value);
  }

  public void setXAErrorFlag(boolean value) {
    connection.setXAErrorFlag(value);
  }

  public void shutdown(DatabaseShutdownMode mode) throws SQLException {
    connection.shutdown(mode);
  }

  public void startup(String startup_str, int mode) throws SQLException {
    connection.startup(startup_str, mode);
  }

  public void startup(DatabaseStartupMode mode) throws SQLException {
    connection.startup(mode);
  }


  public PreparedStatement prepareStatementWithKey(String key)
          throws SQLException {
    return connection.prepareStatementWithKey(key);
  }

  public CallableStatement prepareCallWithKey(String key) throws SQLException {
    return connection.prepareCallWithKey(key);
  }


  public void setCreateStatementAsRefCursor(boolean value) {
    connection.setCreateStatementAsRefCursor(value);
  }

  public boolean getCreateStatementAsRefCursor() {
    return connection.getCreateStatementAsRefCursor();
  }

  public void setSessionTimeZone(String regionName) throws SQLException {
    connection.setSessionTimeZone(regionName);
  }

  public String getSessionTimeZone() {
    return connection.getSessionTimeZone();
  }

  public String getSessionTimeZoneOffset() throws SQLException {
    return connection.getSessionTimeZoneOffset();
  }

  public Connection _getPC() {
    return connection._getPC();
  }

  public boolean isLogicalConnection() {
    return connection.isLogicalConnection();
  }

  public void registerTAFCallback(oracle.jdbc.OracleOCIFailover cbk,
                                  Object obj) throws java.sql.SQLException {
    connection.registerTAFCallback(cbk, obj);
  }


  public java.util.Properties getProperties() {
    return connection.getProperties();
  }

  // Implicit Connection Cache APIs
  public void close(java.util.Properties connAttr) throws SQLException {
    connection.close(connAttr);
  }

  public void close(int opt) throws SQLException {
    connection.close(opt);
  }

  public void applyConnectionAttributes(java.util.Properties connAttr)
          throws SQLException {
    connection.applyConnectionAttributes(connAttr);
  }

  public java.util.Properties getConnectionAttributes() throws SQLException {
    return connection.getConnectionAttributes();
  }

  public java.util.Properties getUnMatchedConnectionAttributes()
          throws SQLException {
    return connection.getUnMatchedConnectionAttributes();
  }

  public void registerConnectionCacheCallback(oracle.jdbc.pool.OracleConnectionCacheCallback occc,
                                              Object userObj,
                                              int cbkFlag) throws SQLException {
    connection.registerConnectionCacheCallback(occc, userObj, cbkFlag);
  }

  public void setConnectionReleasePriority(int priority) throws SQLException {
    connection.setConnectionReleasePriority(priority);
  }

  public int getConnectionReleasePriority() throws SQLException {
    return connection.getConnectionReleasePriority();
  }

  public void setPlsqlWarnings(String setting) throws SQLException {
    connection.setPlsqlWarnings(setting);
  }

  @Override
  public AQNotificationRegistration[] registerAQNotification(String[] strings, Properties[] properties, Properties properties1) throws SQLException {
    return new AQNotificationRegistration[0];
  }

  @Override
  public void unregisterAQNotification(AQNotificationRegistration aqNotificationRegistration) throws SQLException {

  }

  @Override
  public AQMessage dequeue(String s, AQDequeueOptions aqDequeueOptions, byte[] bytes) throws SQLException {
    return null;
  }

  @Override
  public AQMessage dequeue(String s, AQDequeueOptions aqDequeueOptions, String s1) throws SQLException {
    return null;
  }

  @Override
  public void enqueue(String s, AQEnqueueOptions aqEnqueueOptions, AQMessage aqMessage) throws SQLException {

  }

  @Override
  public DatabaseChangeRegistration registerDatabaseChangeNotification(Properties properties) throws SQLException {
    return null;
  }

  @Override
  public DatabaseChangeRegistration getDatabaseChangeRegistration(int i) throws SQLException {
    return null;
  }

  @Override
  public void unregisterDatabaseChangeNotification(DatabaseChangeRegistration databaseChangeRegistration) throws SQLException {

  }

  @Override
  public void unregisterDatabaseChangeNotification(int i, String s, int i1) throws SQLException {

  }

  @Override
  public void unregisterDatabaseChangeNotification(int i) throws SQLException {

  }


  public void setHoldability(int holdability) throws SQLException {
    connection.setHoldability(holdability);
  }

  public int getHoldability() throws SQLException {
    return connection.getHoldability();
  }

  public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
    return connection.createStatement(resultSetType, resultSetConcurrency,
            resultSetHoldability);
  }

  public PreparedStatement prepareStatement(String sql, int resultSetType,
                                            int resultSetConcurrency,
                                            int resultSetHoldability) throws SQLException {
    return connection.prepareStatement(sql, resultSetType,
            resultSetConcurrency,
            resultSetHoldability);
  }

  public CallableStatement prepareCall(String sql, int resultSetType,
                                       int resultSetConcurrency,
                                       int resultSetHoldability) throws SQLException {
    return connection.prepareCall(sql, resultSetType, resultSetConcurrency,
            resultSetHoldability);
  }

  public synchronized java.sql.Savepoint setSavepoint() throws SQLException {
    return connection.setSavepoint();
  }

  public synchronized java.sql.Savepoint setSavepoint(String name)
          throws SQLException {
    return connection.setSavepoint(name);
  }

  public synchronized void rollback(java.sql.Savepoint savepoint)
          throws SQLException {
    connection.rollback(savepoint);
  }

  public synchronized void releaseSavepoint(java.sql.Savepoint savepoint)
          throws SQLException {
    connection.releaseSavepoint(savepoint);
  }

  public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
          throws SQLException {
    return connection.prepareStatement(sql, autoGeneratedKeys);
  }

  public PreparedStatement prepareStatement(String sql, int columnIndexes[])
          throws SQLException {
    return connection.prepareStatement(sql, columnIndexes);
  }

  public PreparedStatement prepareStatement(String sql, String columnNames[])
          throws SQLException {
    return connection.prepareStatement(sql, columnNames);
  }

  @Override
  public Clob createClob() throws SQLException {
    return null;
  }

  @Override
  public Blob createBlob() throws SQLException {
    return null;
  }

  @Override
  public NClob createNClob() throws SQLException {
    return null;
  }

  @Override
  public SQLXML createSQLXML() throws SQLException {
    return null;
  }

  @Override
  public boolean isValid(int timeout) throws SQLException {
    return false;
  }

  @Override
  public void setClientInfo(String name, String value) throws SQLClientInfoException {

  }

  @Override
  public void setClientInfo(Properties properties) throws SQLClientInfoException {

  }

  @Override
  public String getClientInfo(String name) throws SQLException {
    return null;
  }

  @Override
  public Properties getClientInfo() throws SQLException {
    return null;
  }

  @Override
  public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
    return null;
  }

  @Override
  public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
    return null;
  }

  @Override
  public void setSchema(String schema) throws SQLException {

  }

  @Override
  public String getSchema() throws SQLException {
    return null;
  }

  @Override
  public void abort(Executor executor) throws SQLException {

  }

  @Override
  public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {

  }

  @Override
  public int getNetworkTimeout() throws SQLException {
    return 0;
  }

  /**
   * Creates an ARRAY object with the given type name and elements.
   *
   * @param typeName the name of the SQL type of the created object
   * @param elements the elements of the created object
   * @return an ARRAY
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.ARRAY createARRAY(String typeName, Object elements)
          throws SQLException {
    return connection.createARRAY(typeName, elements);
  }



  /**
   * Creates a BINARY_DOUBLE that has the given value.
   *
   * @param value the value that the new object should represent
   * @return a new BINARY_DOUBLE
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.BINARY_DOUBLE createBINARY_DOUBLE(double value) throws SQLException {
    return connection.createBINARY_DOUBLE(value);
  }

  /**
   * Creates a BINARY_FLOAT that has the given value.
   *
   * @param value the value that the new object should represent
   * @return a new BINARY_FLOAT
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.BINARY_FLOAT createBINARY_FLOAT(float value) throws SQLException {
    return connection.createBINARY_FLOAT(value);
  }

  /**
   * Creates a DATE that has the given value.
   *
   * @param value the value that the new object should repreesnt
   * @return a new DATE
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.DATE createDATE(java.sql.Date value) throws SQLException {
    return connection.createDATE(value);
  }

  /**
   * Creates a DATE that has the given value.
   *
   * @param value the value that the new object should repreesnt
   * @return a new DATE
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.DATE createDATE(java.sql.Time value) throws SQLException {
    return connection.createDATE(value);
  }

  /**
   * Creates a DATE that has the given value.
   *
   * @param value the value that the new object should repreesnt
   * @return a new DATE
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.DATE createDATE(java.sql.Timestamp value) throws SQLException {
    return connection.createDATE(value);
  }

  /**
   * Creates a DATE that has the given value. The value is interpreted as being in the
   * time zone represented by cal.
   *
   * @param value the value that the new object should repreesnt
   * @param cal   the timezone in which the value is interpreted
   * @return a new DATE
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.DATE createDATE(java.sql.Date value, java.util.Calendar cal)
          throws SQLException {
    return connection.createDATE(value, cal);
  }

  /**
   * Creates a DATE that has the given value. The value is interpreted as being in the
   * time zone represented by cal.
   *
   * @param value the value that the new object should repreesnt
   * @param cal   the timezone in which the value is interpreted
   * @return a new DATE
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.DATE createDATE(java.sql.Time value, java.util.Calendar cal)
          throws SQLException {
    return connection.createDATE(value, cal);
  }

  /**
   * Creates a DATE that has the given value. The value is interpreted as being in the
   * time zone represented by cal.
   *
   * @param value the value that the new object should repreesnt
   * @param cal   the timezone in which the value is interpreted
   * @return a new DATE
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.DATE createDATE(java.sql.Timestamp value, java.util.Calendar cal)
          throws SQLException {
    return connection.createDATE(value, cal);
  }

  /**
   * Creates a DATE that has the given value.
   *
   * @param value the value that the new object should repreesnt
   * @return a new DATE
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.DATE createDATE(String value) throws SQLException {
    return connection.createDATE(value);
  }

  /**
   * Creates an INTERVALDS that has the given value.
   *
   * @param value the value that the new object shoud represent
   * @return a new INTERVALDS
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.INTERVALDS createINTERVALDS(String value) throws SQLException {
    return connection.createINTERVALDS(value);
  }

  /**
   * Creates an INTERVALYM that has the given value.
   *
   * @param value the value that the new object shoud represent
   * @return a new INTERVALYM
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.INTERVALYM createINTERVALYM(String value) throws SQLException {
    return connection.createINTERVALYM(value);
  }

  /**
   * Creates a new NUMBER that has the given value.
   *
   * @param value the value that the new object should represent
   * @return a new NUMBER
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.NUMBER createNUMBER(boolean value) throws SQLException {
    return connection.createNUMBER(value);
  }

  /**
   * Creates a new NUMBER that has the given value.
   *
   * @param value the value that the new object should represent
   * @return a new NUMBER
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.NUMBER createNUMBER(byte value) throws SQLException {
    return connection.createNUMBER(value);
  }

  /**
   * Creates a new NUMBER that has the given value.
   *
   * @param value the value that the new object should represent
   * @return a new NUMBER
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.NUMBER createNUMBER(short value) throws SQLException {
    return connection.createNUMBER(value);
  }

  /**
   * Creates a new NUMBER that has the given value.
   *
   * @param value the value that the new object should represent
   * @return a new NUMBER
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.NUMBER createNUMBER(int value) throws SQLException {
    return connection.createNUMBER(value);
  }

  /**
   * Creates a new NUMBER that has the given value.
   *
   * @param value the value that the new object should represent
   * @return a new NUMBER
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.NUMBER createNUMBER(long value) throws SQLException {
    return connection.createNUMBER(value);
  }

  /**
   * Creates a new NUMBER that has the given value.
   *
   * @param value the value that the new object should represent
   * @return a new NUMBER
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.NUMBER createNUMBER(float value) throws SQLException {
    return connection.createNUMBER(value);
  }

  /**
   * Creates a new NUMBER that has the given value.
   *
   * @param value the value that the new object should represent
   * @return a new NUMBER
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.NUMBER createNUMBER(double value) throws SQLException {
    return connection.createNUMBER(value);
  }

  /**
   * Creates a new NUMBER that has the given value.
   *
   * @param value the value that the new object should represent
   * @return a new NUMBER
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.NUMBER createNUMBER(java.math.BigDecimal value) throws SQLException {
    return connection.createNUMBER(value);
  }

  /**
   * Creates a new NUMBER that has the given value.
   *
   * @param value the value that the new object should represent
   * @return a new NUMBER
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.NUMBER createNUMBER(java.math.BigInteger value) throws SQLException {
    return connection.createNUMBER(value);
  }

  /**
   * Creates a new NUMBER that has the given value and scale.
   *
   * @param value the value that the new object should represent
   * @param scale the scale of the new object
   * @return a new NUMBER
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.NUMBER createNUMBER(String value, int scale) throws SQLException {
    return connection.createNUMBER(value, scale);
  }

  /**
   * Creates a new TIMESTAMP with the given value.
   *
   * @param value the value that the new object should represent
   * @return a new TIMESTAMP
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.TIMESTAMP createTIMESTAMP(java.sql.Date value) throws SQLException {
    return connection.createTIMESTAMP(value);
  }

  /**
   * Creates a new TIMESTAMP with the given value.
   *
   * @param value the value that the new object should represent
   * @return a new TIMESTAMP
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.TIMESTAMP createTIMESTAMP(oracle.sql.DATE value) throws SQLException {
    return connection.createTIMESTAMP(value);
  }

  /**
   * Creates a new TIMESTAMP with the given value.
   *
   * @param value the value that the new object should represent
   * @return a new TIMESTAMP
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.TIMESTAMP createTIMESTAMP(java.sql.Time value) throws SQLException {
    return connection.createTIMESTAMP(value);
  }

  /**
   * Creates a new TIMESTAMP with the given value.
   *
   * @param value the value that the new object should represent
   * @return a new TIMESTAMP
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.TIMESTAMP createTIMESTAMP(java.sql.Timestamp value) throws SQLException {
    return connection.createTIMESTAMP(value);
  }



  /**
   * Creates a new TIMESTAMP with the given value.
   *
   * @param value the value that the new object should represent
   * @return a new TIMESTAMP
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.TIMESTAMP createTIMESTAMP(String value) throws SQLException {
    return connection.createTIMESTAMP(value);
  }

  /**
   * Creates a new TIMESTAMPTZ with the given value.
   *
   * @param value the value that the new object should represent
   * @return a new TIMESTAMPTZ
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.TIMESTAMPTZ createTIMESTAMPTZ(java.sql.Date value) throws SQLException {
    return connection.createTIMESTAMPTZ(value);
  }

  /**
   * Creates a new TIMESTAMPTZ with the given value. The value is interpreted in the
   * time zone of the calendar.
   *
   * @param value the value that the new object should represent
   * @param cal   the timezone of the value
   * @return a new TIMESTAMPTZ
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.TIMESTAMPTZ createTIMESTAMPTZ(java.sql.Date value,
                                                  java.util.Calendar cal)
          throws SQLException {
    return connection.createTIMESTAMPTZ(value, cal);
  }

  /**
   * Creates a new TIMESTAMPTZ with the given value.
   *
   * @param value the value that the new object should represent
   * @return a new TIMESTAMPTZ
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.TIMESTAMPTZ createTIMESTAMPTZ(java.sql.Time value) throws SQLException {
    return connection.createTIMESTAMPTZ(value);
  }

  /**
   * Creates a new TIMESTAMPTZ with the given value. The value is interpreted in the
   * time zone of the calendar.
   *
   * @param value the value that the new object should represent
   * @param cal   the timezone of the value
   * @return a new TIMESTAMPTZ
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.TIMESTAMPTZ createTIMESTAMPTZ(java.sql.Time value,
                                                  java.util.Calendar cal)
          throws SQLException {
    return connection.createTIMESTAMPTZ(value, cal);
  }

  /**
   * Creates a new TIMESTAMPTZ with the given value.
   *
   * @param value the value that the new object should represent
   * @return a new TIMESTAMPTZ
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.TIMESTAMPTZ createTIMESTAMPTZ(java.sql.Timestamp value) throws SQLException {
    return connection.createTIMESTAMPTZ(value);
  }

  /**
   * Creates a new TIMESTAMPTZ with the given value. The value is interpreted in the
   * time zone of the calendar.
   *
   * @param value the value that the new object should represent
   * @param cal   the timezone of the value
   * @return a new TIMESTAMPTZ
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.TIMESTAMPTZ createTIMESTAMPTZ(java.sql.Timestamp value,
                                                  java.util.Calendar cal)
          throws SQLException {
    return connection.createTIMESTAMPTZ(value, cal);
  }

  /**
   * Creates a new TIMESTAMPTZ with the given value.
   *
   * @param value the value that the new object should represent
   * @return a new TIMESTAMPTZ
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.TIMESTAMPTZ createTIMESTAMPTZ(String value) throws SQLException {
    return connection.createTIMESTAMPTZ(value);
  }

  /**
   * Creates a new TIMESTAMPTZ with the given value. The value is interpreted in the
   * time zone of the calendar.
   *
   * @param value the value that the new object should represent
   * @param cal   the timezone of the value
   * @return a new TIMESTAMPTZ
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.TIMESTAMPTZ createTIMESTAMPTZ(String value,
                                                  java.util.Calendar cal)
          throws SQLException {
    return connection.createTIMESTAMPTZ(value, cal);
  }

  /**
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.TIMESTAMPTZ createTIMESTAMPTZ(oracle.sql.DATE value) throws SQLException {
    return connection.createTIMESTAMPTZ(value);
  }

  /**
   * Creates a new TIMESTAMPLTZ with the given value. The value is interpreted in the
   * time zone of the calendar.
   *
   * @param value the value that the new object should represent
   * @param cal   the timezone of the value
   * @return a new TIMESTAMPLTZ
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.TIMESTAMPLTZ createTIMESTAMPLTZ(java.sql.Date value,
                                                    java.util.Calendar cal)
          throws SQLException {
    return connection.createTIMESTAMPLTZ(value, cal);
  }

  /**
   * Creates a new TIMESTAMPLTZ with the given value. The value is interpreted in the
   * time zone of the calendar.
   *
   * @param value the value that the new object should represent
   * @param cal   the timezone of the value
   * @return a new TIMESTAMPLTZ
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.TIMESTAMPLTZ createTIMESTAMPLTZ(java.sql.Time value,
                                                    java.util.Calendar cal)
          throws SQLException {
    return connection.createTIMESTAMPLTZ(value, cal);
  }

  /**
   * Creates a new TIMESTAMPLTZ with the given value. The value is interpreted in the
   * time zone of the calendar.
   *
   * @param value the value that the new object should represent
   * @param cal   the timezone of the value
   * @return a new TIMESTAMPLTZ
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.TIMESTAMPLTZ createTIMESTAMPLTZ(java.sql.Timestamp value,
                                                    java.util.Calendar cal)
          throws SQLException {
    return connection.createTIMESTAMPLTZ(value, cal);
  }

  /**
   * Creates a new TIMESTAMPLTZ with the given value. The value is interpreted in the
   * time zone of the calendar.
   *
   * @param value the value that the new object should represent
   * @param cal   the timezone of the value
   * @return a new TIMESTAMPLTZ
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.TIMESTAMPLTZ createTIMESTAMPLTZ(String value,
                                                    java.util.Calendar cal)
          throws SQLException {
    return connection.createTIMESTAMPLTZ(value, cal);
  }

  /**
   * Creates a new TIMESTAMPLTZ with the given value. The value is interpreted in the
   * time zone of the calendar.
   *
   * @param value the value that the new object should represent
   * @param cal   the timezone of the value
   * @return a new TIMESTAMPLTZ
   * @throws SQLException if a database error occurs
   * @since 11R1
   */
  public oracle.sql.TIMESTAMPLTZ createTIMESTAMPLTZ(oracle.sql.DATE value,
                                                    java.util.Calendar cal)
          throws SQLException {
    return connection.createTIMESTAMPLTZ(value, cal);
  }

  @Override
  public void cancel() throws SQLException {

  }

  @Override
  public void abort() throws SQLException {

  }

  @Override
  public TypeDescriptor[] getAllTypeDescriptorsInCurrentSchema() throws SQLException {
    return new TypeDescriptor[0];
  }

  @Override
  public TypeDescriptor[] getTypeDescriptorsFromListInCurrentSchema(String[] strings) throws SQLException {
    return new TypeDescriptor[0];
  }

  @Override
  public TypeDescriptor[] getTypeDescriptorsFromList(String[][] strings) throws SQLException {
    return new TypeDescriptor[0];
  }

  @Override
  public String getDataIntegrityAlgorithmName() throws SQLException {
    return null;
  }

  @Override
  public String getEncryptionAlgorithmName() throws SQLException {
    return null;
  }

  @Override
  public String getAuthenticationAdaptorName() throws SQLException {
    return null;
  }

  @Override
  public boolean isUsable() {
    return false;
  }

  @Override
  public void setDefaultTimeZone(TimeZone timeZone) throws SQLException {

  }

  @Override
  public TimeZone getDefaultTimeZone() throws SQLException {
    return null;
  }

  @Override
  public void setApplicationContext(String s, String s1, String s2) throws SQLException {

  }

  @Override
  public void clearAllApplicationContext(String s) throws SQLException {

  }


  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    return null;
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    return false;
  }
}

/**
 * @version $Header: dbjava/src/java/oracle/jdbc/OracleConnectionWrapper.java /main/48 2009/04/20 13:16:03 scheng Exp $
 * @author  eshirk
 * @since   9.2
 */


