import java.util.Arrays;
import java.util.Base64;

public class Main {
    public static void main (String[] args) {
        System.out.println(Arrays.toString(inputText("Beispiel")));
        System.out.println(Arrays.toString(inputBase64("QmVpc3BpZWw=")));
        System.out.println(Arrays.toString(inputDecimal("66,101,105,115,112,105,101,108")));
        System.out.println(Arrays.toString(inputHexadecimal("42,65,69,73,70,69,65,6c")));
        System.out.println(Arrays.toString(inputBinary("01000010,01100101,01101001,01110011,01110000,01101001,01100101,01101100")));
    }




    public static String decimalToText(byte[] array){
        return new String(array);
    }

    public static byte[] textToDecimal(String text){
        return text.getBytes();
    }


    public static String decimalToBase64(byte[] array){
        return Base64.getEncoder().encodeToString(array);
    }

    public static byte[] base64ToDecimal(String text){
        return Base64.getDecoder().decode(text);
    }


    public static String decimalToHexadecimal (byte[] array) {
        String hexadecimalFromDecimal = "";
        for (byte part : array) {
            hexadecimalFromDecimal += Integer.toHexString(part);
            if (array[array.length - 1] != part) {
                hexadecimalFromDecimal += ",";
            }
        }
        return hexadecimalFromDecimal;
    }

    public static byte[] hexadecimalToDecimal (String string) {
        String[] parts = string.replaceAll(" ", "").split(",");
        byte[] decimalFromHexadecimal = new byte[parts.length];
        for (int i = 0; i < parts.length; i++) {
            decimalFromHexadecimal[i] = (byte) Integer.parseInt(parts[i], 16);
        }
        return decimalFromHexadecimal;
    }


    public static String decimalToBinary (byte[] array) {
        String binaryFromDecimal = "";
        for (byte part : array) {
            binaryFromDecimal += String.format("%8s", Integer.toBinaryString(part)).replace(' ', '0');
            if (array[array.length - 1] != part){
                binaryFromDecimal += ",";
            }
        }
        return binaryFromDecimal;
    }

    public static byte[] binaryToDecimal (String string) {
        String[] parts = string.replaceAll(" ", "").split(",");
        byte[] decimalFromBinary = new byte[parts.length];
        for (int i = 0; i < parts.length; i++) {
            decimalFromBinary[i] = (byte) Integer.parseInt(parts[i], 2);
        }
        return decimalFromBinary;
    }




    public static String ByteArrayToString (byte[] array) {
        return (Arrays.toString(array).substring(1, Arrays.toString(array).length() - 1)).replaceAll(" ", "");
    }

    public static byte[] StringToByteArray (String string) {
        String[] parts = string.replaceAll(" ", "").split(",");
        byte[] byteArray = new byte[parts.length];
        for (int i = 0; i < parts.length; i++) {
            byteArray[i] = (byte) Integer.parseInt(parts[i]);
        }
        return byteArray;
    }




    public static String[] inputDecimal (String input) {
        String[] outputArray = new String[5];
        byte[] decimal = StringToByteArray(input);
        outputArray[0] = input;
        outputArray[1] = decimalToText(decimal);
        outputArray[2] = decimalToBase64(decimal);
        outputArray[3] = decimalToHexadecimal(decimal);
        outputArray[4] = decimalToBinary(decimal);
        return outputArray;
    }


    public static String[] inputText (String input) {
        String[] outputArray = new String[5];
        byte[] decimal = textToDecimal(input);
        outputArray[0] = ByteArrayToString(decimal);
        outputArray[1] = input;
        outputArray[2] = decimalToBase64(decimal);
        outputArray[3] = decimalToHexadecimal(decimal);
        outputArray[4] = decimalToBinary(decimal);
        return outputArray;
    }


    public static String[] inputBase64 (String input) {
        String[] outputArray = new String[5];
        byte[] decimal = base64ToDecimal(input);
        outputArray[0] = ByteArrayToString(decimal);
        outputArray[1] = decimalToText(decimal);
        outputArray[2] = input;
        outputArray[3] = decimalToHexadecimal(decimal);
        outputArray[4] = decimalToBinary(decimal);
        return outputArray;
    }


    public static String[] inputHexadecimal (String input) {
        String[] outputArray = new String[5];
        byte[] decimal = hexadecimalToDecimal(input);
        outputArray[0] = ByteArrayToString(decimal);
        outputArray[1] = decimalToText(decimal);
        outputArray[2] = decimalToBase64(decimal);
        outputArray[3] = input;
        outputArray[4] = decimalToBinary(decimal);
        return outputArray;
    }


    public static String[] inputBinary (String input) {
        String[] outputArray = new String[5];
        byte[] decimal = binaryToDecimal(input);
        outputArray[0] = ByteArrayToString(decimal);
        outputArray[1] = decimalToText(decimal);
        outputArray[2] = decimalToBase64(decimal);
        outputArray[3] = decimalToHexadecimal(decimal);
        outputArray[4] = input;
        return outputArray;
    }
}