package uz.liti.configurator4j;

import org.apache.plc4x.java.PlcDriverManager;
import org.apache.plc4x.java.api.PlcConnection;
import org.apache.plc4x.java.api.messages.PlcReadRequest;
import org.apache.plc4x.java.api.messages.PlcReadResponse;
import org.apache.plc4x.java.api.messages.PlcRequest;
import org.apache.plc4x.java.api.types.PlcClientDatatype;
import org.apache.plc4x.java.modbus.config.ModbusConfiguration;
import org.apache.plc4x.java.modbus.field.ModbusField;
import org.apache.plc4x.java.modbus.field.ModbusFieldInputRegister;
import org.apache.plc4x.java.modbus.readwrite.ModbusTcpADU;

import java.util.concurrent.CompletableFuture;

public class Test {
    public static void main(String[] args) {
        ModbusConfiguration configuration=new ModbusConfiguration();
        System.out.println(ModbusFieldInputRegister.matches("0"));
        System.out.println(ModbusFieldInputRegister.matches("1"));
        System.out.println(ModbusFieldInputRegister.matches("2"));
        System.out.println(ModbusFieldInputRegister.matches("4"));
        System.out.println(ModbusFieldInputRegister.matches("5"));
        String connectionString = "modbus://localhost:1522";


        try (PlcConnection plcConnection = new PlcDriverManager().getConnection(connectionString)) {
            plcConnection.connect();
//            System.out.println(plcConnection.getMetadata());
            System.out.println(plcConnection.isConnected());
            var builder=plcConnection.readRequestBuilder().addItem("value-3", "input-register:5");

            PlcReadRequest readRequest = builder.build();
//            CompletableFuture<? extends PlcReadResponse> asyncResponse = readRequest.execute();
//            asyncResponse.whenComplete((response, throwable) -> {
//                System.out.println("************************************************");
//                System.out.println(response);
//            });
            PlcReadResponse response = readRequest.execute().get();
            System.out.println(response);
            System.out.println(response.getAllBigIntegers("value-3"));
            System.out.println(response.getFieldNames());

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
