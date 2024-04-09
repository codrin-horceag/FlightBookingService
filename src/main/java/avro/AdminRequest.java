/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class AdminRequest extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6401227355312825156L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AdminRequest\",\"namespace\":\"avro\",\"fields\":[{\"name\":\"id\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"bookingId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"operatorId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"flightId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"departure\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"destination\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"numberOfSeats\",\"type\":\"int\"},{\"name\":\"standardPrice\",\"type\":\"double\"},{\"name\":\"date\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"status\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<AdminRequest> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AdminRequest> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<AdminRequest> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<AdminRequest> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<AdminRequest> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this AdminRequest to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a AdminRequest from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a AdminRequest instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static AdminRequest fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String id;
  private java.lang.String bookingId;
  private java.lang.String operatorId;
  private java.lang.String flightId;
  private java.lang.String departure;
  private java.lang.String destination;
  private int numberOfSeats;
  private double standardPrice;
  private java.lang.String date;
  private java.lang.String status;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AdminRequest() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param bookingId The new value for bookingId
   * @param operatorId The new value for operatorId
   * @param flightId The new value for flightId
   * @param departure The new value for departure
   * @param destination The new value for destination
   * @param numberOfSeats The new value for numberOfSeats
   * @param standardPrice The new value for standardPrice
   * @param date The new value for date
   * @param status The new value for status
   */
  public AdminRequest(java.lang.String id, java.lang.String bookingId, java.lang.String operatorId, java.lang.String flightId, java.lang.String departure, java.lang.String destination, java.lang.Integer numberOfSeats, java.lang.Double standardPrice, java.lang.String date, java.lang.String status) {
    this.id = id;
    this.bookingId = bookingId;
    this.operatorId = operatorId;
    this.flightId = flightId;
    this.departure = departure;
    this.destination = destination;
    this.numberOfSeats = numberOfSeats;
    this.standardPrice = standardPrice;
    this.date = date;
    this.status = status;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return bookingId;
    case 2: return operatorId;
    case 3: return flightId;
    case 4: return departure;
    case 5: return destination;
    case 6: return numberOfSeats;
    case 7: return standardPrice;
    case 8: return date;
    case 9: return status;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = value$ != null ? value$.toString() : null; break;
    case 1: bookingId = value$ != null ? value$.toString() : null; break;
    case 2: operatorId = value$ != null ? value$.toString() : null; break;
    case 3: flightId = value$ != null ? value$.toString() : null; break;
    case 4: departure = value$ != null ? value$.toString() : null; break;
    case 5: destination = value$ != null ? value$.toString() : null; break;
    case 6: numberOfSeats = (java.lang.Integer)value$; break;
    case 7: standardPrice = (java.lang.Double)value$; break;
    case 8: date = value$ != null ? value$.toString() : null; break;
    case 9: status = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.String getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.String value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'bookingId' field.
   * @return The value of the 'bookingId' field.
   */
  public java.lang.String getBookingId() {
    return bookingId;
  }


  /**
   * Sets the value of the 'bookingId' field.
   * @param value the value to set.
   */
  public void setBookingId(java.lang.String value) {
    this.bookingId = value;
  }

  /**
   * Gets the value of the 'operatorId' field.
   * @return The value of the 'operatorId' field.
   */
  public java.lang.String getOperatorId() {
    return operatorId;
  }


  /**
   * Sets the value of the 'operatorId' field.
   * @param value the value to set.
   */
  public void setOperatorId(java.lang.String value) {
    this.operatorId = value;
  }

  /**
   * Gets the value of the 'flightId' field.
   * @return The value of the 'flightId' field.
   */
  public java.lang.String getFlightId() {
    return flightId;
  }


  /**
   * Sets the value of the 'flightId' field.
   * @param value the value to set.
   */
  public void setFlightId(java.lang.String value) {
    this.flightId = value;
  }

  /**
   * Gets the value of the 'departure' field.
   * @return The value of the 'departure' field.
   */
  public java.lang.String getDeparture() {
    return departure;
  }


  /**
   * Sets the value of the 'departure' field.
   * @param value the value to set.
   */
  public void setDeparture(java.lang.String value) {
    this.departure = value;
  }

  /**
   * Gets the value of the 'destination' field.
   * @return The value of the 'destination' field.
   */
  public java.lang.String getDestination() {
    return destination;
  }


  /**
   * Sets the value of the 'destination' field.
   * @param value the value to set.
   */
  public void setDestination(java.lang.String value) {
    this.destination = value;
  }

  /**
   * Gets the value of the 'numberOfSeats' field.
   * @return The value of the 'numberOfSeats' field.
   */
  public int getNumberOfSeats() {
    return numberOfSeats;
  }


  /**
   * Sets the value of the 'numberOfSeats' field.
   * @param value the value to set.
   */
  public void setNumberOfSeats(int value) {
    this.numberOfSeats = value;
  }

  /**
   * Gets the value of the 'standardPrice' field.
   * @return The value of the 'standardPrice' field.
   */
  public double getStandardPrice() {
    return standardPrice;
  }


  /**
   * Sets the value of the 'standardPrice' field.
   * @param value the value to set.
   */
  public void setStandardPrice(double value) {
    this.standardPrice = value;
  }

  /**
   * Gets the value of the 'date' field.
   * @return The value of the 'date' field.
   */
  public java.lang.String getDate() {
    return date;
  }


  /**
   * Sets the value of the 'date' field.
   * @param value the value to set.
   */
  public void setDate(java.lang.String value) {
    this.date = value;
  }

  /**
   * Gets the value of the 'status' field.
   * @return The value of the 'status' field.
   */
  public java.lang.String getStatus() {
    return status;
  }


  /**
   * Sets the value of the 'status' field.
   * @param value the value to set.
   */
  public void setStatus(java.lang.String value) {
    this.status = value;
  }

  /**
   * Creates a new AdminRequest RecordBuilder.
   * @return A new AdminRequest RecordBuilder
   */
  public static avro.AdminRequest.Builder newBuilder() {
    return new avro.AdminRequest.Builder();
  }

  /**
   * Creates a new AdminRequest RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AdminRequest RecordBuilder
   */
  public static avro.AdminRequest.Builder newBuilder(avro.AdminRequest.Builder other) {
    if (other == null) {
      return new avro.AdminRequest.Builder();
    } else {
      return new avro.AdminRequest.Builder(other);
    }
  }

  /**
   * Creates a new AdminRequest RecordBuilder by copying an existing AdminRequest instance.
   * @param other The existing instance to copy.
   * @return A new AdminRequest RecordBuilder
   */
  public static avro.AdminRequest.Builder newBuilder(avro.AdminRequest other) {
    if (other == null) {
      return new avro.AdminRequest.Builder();
    } else {
      return new avro.AdminRequest.Builder(other);
    }
  }

  /**
   * RecordBuilder for AdminRequest instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AdminRequest>
    implements org.apache.avro.data.RecordBuilder<AdminRequest> {

    private java.lang.String id;
    private java.lang.String bookingId;
    private java.lang.String operatorId;
    private java.lang.String flightId;
    private java.lang.String departure;
    private java.lang.String destination;
    private int numberOfSeats;
    private double standardPrice;
    private java.lang.String date;
    private java.lang.String status;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(avro.AdminRequest.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.bookingId)) {
        this.bookingId = data().deepCopy(fields()[1].schema(), other.bookingId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.operatorId)) {
        this.operatorId = data().deepCopy(fields()[2].schema(), other.operatorId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.flightId)) {
        this.flightId = data().deepCopy(fields()[3].schema(), other.flightId);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.departure)) {
        this.departure = data().deepCopy(fields()[4].schema(), other.departure);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.destination)) {
        this.destination = data().deepCopy(fields()[5].schema(), other.destination);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.numberOfSeats)) {
        this.numberOfSeats = data().deepCopy(fields()[6].schema(), other.numberOfSeats);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.standardPrice)) {
        this.standardPrice = data().deepCopy(fields()[7].schema(), other.standardPrice);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (isValidValue(fields()[8], other.date)) {
        this.date = data().deepCopy(fields()[8].schema(), other.date);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
      if (isValidValue(fields()[9], other.status)) {
        this.status = data().deepCopy(fields()[9].schema(), other.status);
        fieldSetFlags()[9] = other.fieldSetFlags()[9];
      }
    }

    /**
     * Creates a Builder by copying an existing AdminRequest instance
     * @param other The existing instance to copy.
     */
    private Builder(avro.AdminRequest other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.bookingId)) {
        this.bookingId = data().deepCopy(fields()[1].schema(), other.bookingId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.operatorId)) {
        this.operatorId = data().deepCopy(fields()[2].schema(), other.operatorId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.flightId)) {
        this.flightId = data().deepCopy(fields()[3].schema(), other.flightId);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.departure)) {
        this.departure = data().deepCopy(fields()[4].schema(), other.departure);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.destination)) {
        this.destination = data().deepCopy(fields()[5].schema(), other.destination);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.numberOfSeats)) {
        this.numberOfSeats = data().deepCopy(fields()[6].schema(), other.numberOfSeats);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.standardPrice)) {
        this.standardPrice = data().deepCopy(fields()[7].schema(), other.standardPrice);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.date)) {
        this.date = data().deepCopy(fields()[8].schema(), other.date);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.status)) {
        this.status = data().deepCopy(fields()[9].schema(), other.status);
        fieldSetFlags()[9] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.String getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public avro.AdminRequest.Builder setId(java.lang.String value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public avro.AdminRequest.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'bookingId' field.
      * @return The value.
      */
    public java.lang.String getBookingId() {
      return bookingId;
    }


    /**
      * Sets the value of the 'bookingId' field.
      * @param value The value of 'bookingId'.
      * @return This builder.
      */
    public avro.AdminRequest.Builder setBookingId(java.lang.String value) {
      validate(fields()[1], value);
      this.bookingId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'bookingId' field has been set.
      * @return True if the 'bookingId' field has been set, false otherwise.
      */
    public boolean hasBookingId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'bookingId' field.
      * @return This builder.
      */
    public avro.AdminRequest.Builder clearBookingId() {
      bookingId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'operatorId' field.
      * @return The value.
      */
    public java.lang.String getOperatorId() {
      return operatorId;
    }


    /**
      * Sets the value of the 'operatorId' field.
      * @param value The value of 'operatorId'.
      * @return This builder.
      */
    public avro.AdminRequest.Builder setOperatorId(java.lang.String value) {
      validate(fields()[2], value);
      this.operatorId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'operatorId' field has been set.
      * @return True if the 'operatorId' field has been set, false otherwise.
      */
    public boolean hasOperatorId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'operatorId' field.
      * @return This builder.
      */
    public avro.AdminRequest.Builder clearOperatorId() {
      operatorId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'flightId' field.
      * @return The value.
      */
    public java.lang.String getFlightId() {
      return flightId;
    }


    /**
      * Sets the value of the 'flightId' field.
      * @param value The value of 'flightId'.
      * @return This builder.
      */
    public avro.AdminRequest.Builder setFlightId(java.lang.String value) {
      validate(fields()[3], value);
      this.flightId = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'flightId' field has been set.
      * @return True if the 'flightId' field has been set, false otherwise.
      */
    public boolean hasFlightId() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'flightId' field.
      * @return This builder.
      */
    public avro.AdminRequest.Builder clearFlightId() {
      flightId = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'departure' field.
      * @return The value.
      */
    public java.lang.String getDeparture() {
      return departure;
    }


    /**
      * Sets the value of the 'departure' field.
      * @param value The value of 'departure'.
      * @return This builder.
      */
    public avro.AdminRequest.Builder setDeparture(java.lang.String value) {
      validate(fields()[4], value);
      this.departure = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'departure' field has been set.
      * @return True if the 'departure' field has been set, false otherwise.
      */
    public boolean hasDeparture() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'departure' field.
      * @return This builder.
      */
    public avro.AdminRequest.Builder clearDeparture() {
      departure = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'destination' field.
      * @return The value.
      */
    public java.lang.String getDestination() {
      return destination;
    }


    /**
      * Sets the value of the 'destination' field.
      * @param value The value of 'destination'.
      * @return This builder.
      */
    public avro.AdminRequest.Builder setDestination(java.lang.String value) {
      validate(fields()[5], value);
      this.destination = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'destination' field has been set.
      * @return True if the 'destination' field has been set, false otherwise.
      */
    public boolean hasDestination() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'destination' field.
      * @return This builder.
      */
    public avro.AdminRequest.Builder clearDestination() {
      destination = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'numberOfSeats' field.
      * @return The value.
      */
    public int getNumberOfSeats() {
      return numberOfSeats;
    }


    /**
      * Sets the value of the 'numberOfSeats' field.
      * @param value The value of 'numberOfSeats'.
      * @return This builder.
      */
    public avro.AdminRequest.Builder setNumberOfSeats(int value) {
      validate(fields()[6], value);
      this.numberOfSeats = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'numberOfSeats' field has been set.
      * @return True if the 'numberOfSeats' field has been set, false otherwise.
      */
    public boolean hasNumberOfSeats() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'numberOfSeats' field.
      * @return This builder.
      */
    public avro.AdminRequest.Builder clearNumberOfSeats() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'standardPrice' field.
      * @return The value.
      */
    public double getStandardPrice() {
      return standardPrice;
    }


    /**
      * Sets the value of the 'standardPrice' field.
      * @param value The value of 'standardPrice'.
      * @return This builder.
      */
    public avro.AdminRequest.Builder setStandardPrice(double value) {
      validate(fields()[7], value);
      this.standardPrice = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'standardPrice' field has been set.
      * @return True if the 'standardPrice' field has been set, false otherwise.
      */
    public boolean hasStandardPrice() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'standardPrice' field.
      * @return This builder.
      */
    public avro.AdminRequest.Builder clearStandardPrice() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'date' field.
      * @return The value.
      */
    public java.lang.String getDate() {
      return date;
    }


    /**
      * Sets the value of the 'date' field.
      * @param value The value of 'date'.
      * @return This builder.
      */
    public avro.AdminRequest.Builder setDate(java.lang.String value) {
      validate(fields()[8], value);
      this.date = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'date' field has been set.
      * @return True if the 'date' field has been set, false otherwise.
      */
    public boolean hasDate() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'date' field.
      * @return This builder.
      */
    public avro.AdminRequest.Builder clearDate() {
      date = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'status' field.
      * @return The value.
      */
    public java.lang.String getStatus() {
      return status;
    }


    /**
      * Sets the value of the 'status' field.
      * @param value The value of 'status'.
      * @return This builder.
      */
    public avro.AdminRequest.Builder setStatus(java.lang.String value) {
      validate(fields()[9], value);
      this.status = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'status' field has been set.
      * @return True if the 'status' field has been set, false otherwise.
      */
    public boolean hasStatus() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'status' field.
      * @return This builder.
      */
    public avro.AdminRequest.Builder clearStatus() {
      status = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AdminRequest build() {
      try {
        AdminRequest record = new AdminRequest();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
        record.bookingId = fieldSetFlags()[1] ? this.bookingId : (java.lang.String) defaultValue(fields()[1]);
        record.operatorId = fieldSetFlags()[2] ? this.operatorId : (java.lang.String) defaultValue(fields()[2]);
        record.flightId = fieldSetFlags()[3] ? this.flightId : (java.lang.String) defaultValue(fields()[3]);
        record.departure = fieldSetFlags()[4] ? this.departure : (java.lang.String) defaultValue(fields()[4]);
        record.destination = fieldSetFlags()[5] ? this.destination : (java.lang.String) defaultValue(fields()[5]);
        record.numberOfSeats = fieldSetFlags()[6] ? this.numberOfSeats : (java.lang.Integer) defaultValue(fields()[6]);
        record.standardPrice = fieldSetFlags()[7] ? this.standardPrice : (java.lang.Double) defaultValue(fields()[7]);
        record.date = fieldSetFlags()[8] ? this.date : (java.lang.String) defaultValue(fields()[8]);
        record.status = fieldSetFlags()[9] ? this.status : (java.lang.String) defaultValue(fields()[9]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<AdminRequest>
    WRITER$ = (org.apache.avro.io.DatumWriter<AdminRequest>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AdminRequest>
    READER$ = (org.apache.avro.io.DatumReader<AdminRequest>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    if (this.id == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.id);
    }

    out.writeString(this.bookingId);

    out.writeString(this.operatorId);

    out.writeString(this.flightId);

    out.writeString(this.departure);

    out.writeString(this.destination);

    out.writeInt(this.numberOfSeats);

    out.writeDouble(this.standardPrice);

    out.writeString(this.date);

    out.writeString(this.status);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (in.readIndex() != 1) {
        in.readNull();
        this.id = null;
      } else {
        this.id = in.readString();
      }

      this.bookingId = in.readString();

      this.operatorId = in.readString();

      this.flightId = in.readString();

      this.departure = in.readString();

      this.destination = in.readString();

      this.numberOfSeats = in.readInt();

      this.standardPrice = in.readDouble();

      this.date = in.readString();

      this.status = in.readString();

    } else {
      for (int i = 0; i < 10; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (in.readIndex() != 1) {
            in.readNull();
            this.id = null;
          } else {
            this.id = in.readString();
          }
          break;

        case 1:
          this.bookingId = in.readString();
          break;

        case 2:
          this.operatorId = in.readString();
          break;

        case 3:
          this.flightId = in.readString();
          break;

        case 4:
          this.departure = in.readString();
          break;

        case 5:
          this.destination = in.readString();
          break;

        case 6:
          this.numberOfSeats = in.readInt();
          break;

        case 7:
          this.standardPrice = in.readDouble();
          break;

        case 8:
          this.date = in.readString();
          break;

        case 9:
          this.status = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










