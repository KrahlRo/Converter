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




    private static String decimalToText (byte[] array) {
        return new String(array);
    }

    private static byte[] textToDecimal (String string) {
        return string.getBytes();
    }


    private static String decimalToBase64 (byte[] array) {
        return Base64.getEncoder().encodeToString(array);
    }

    private static byte[] base64ToDecimal (String string) {
        return Base64.getDecoder().decode(string);
    }


    private static String decimalToHexadecimal (byte[] array) {
        StringBuilder hexadecimalFromDecimal = new StringBuilder();
        for (byte part : array) {
            hexadecimalFromDecimal.append(Integer.toHexString(part));
            if (array[array.length - 1] != part) {
                hexadecimalFromDecimal.append(",");
            }
        }
        return hexadecimalFromDecimal.toString();
    }

    private static byte[] hexadecimalToDecimal (String string) {
        String[] parts = string.replaceAll(" ", "").split(",");
        byte[] decimalFromHexadecimal = new byte[parts.length];
        for (int i = 0; i < parts.length; i++) {
            decimalFromHexadecimal[i] = (byte) Integer.parseInt(parts[i], 16);
        }
        return decimalFromHexadecimal;
    }


    private static String decimalToBinary (byte[] array) {
        StringBuilder binaryFromDecimal = new StringBuilder();
        for (byte part : array) {
            binaryFromDecimal.append(String.format("%8s", Integer.toBinaryString(part)).replace(' ', '0'));
            if (array[array.length - 1] != part) {
                binaryFromDecimal.append(",");
            }
        }
        return binaryFromDecimal.toString();
    }

    private static byte[] binaryToDecimal (String string) {
        String[] parts = string.replaceAll(" ", "").split(",");
        byte[] decimalFromBinary = new byte[parts.length];
        for (int i = 0; i < parts.length; i++) {
            decimalFromBinary[i] = (byte) Integer.parseInt(parts[i], 2);
        }
        return decimalFromBinary;
    }




    private static String byteArrayToString (byte[] array) {
        return (Arrays.toString(array).substring(1, Arrays.toString(array).length() - 1)).replaceAll(" ", "");
    }

    private static byte[] stringToByteArray (String string) {
        String[] parts = string.replaceAll(" ", "").split(",");
        byte[] byteArray = new byte[parts.length];
        for (int i = 0; i < parts.length; i++) {
            byteArray[i] = (byte) Integer.parseInt(parts[i]);
        }
        return byteArray;
    }




    private static String[] inputDecimal (String input) {
        String[] outputArray = new String[5];
        byte[] decimal = stringToByteArray(input);
        outputArray[0] = input;
        outputArray[1] = decimalToText(decimal);
        outputArray[2] = decimalToBase64(decimal);
        outputArray[3] = decimalToHexadecimal(decimal);
        outputArray[4] = decimalToBinary(decimal);
        return outputArray;
    }


    private static String[] inputText (String input) {
        String[] outputArray = new String[5];
        byte[] decimal = textToDecimal(input);
        outputArray[0] = byteArrayToString(decimal);
        outputArray[1] = input;
        outputArray[2] = decimalToBase64(decimal);
        outputArray[3] = decimalToHexadecimal(decimal);
        outputArray[4] = decimalToBinary(decimal);
        return outputArray;
    }


    private static String[] inputBase64 (String input) {
        String[] outputArray = new String[5];
        byte[] decimal = base64ToDecimal(input);
        outputArray[0] = byteArrayToString(decimal);
        outputArray[1] = decimalToText(decimal);
        outputArray[2] = input;
        outputArray[3] = decimalToHexadecimal(decimal);
        outputArray[4] = decimalToBinary(decimal);
        return outputArray;
    }


    private static String[] inputHexadecimal (String input) {
        String[] outputArray = new String[5];
        byte[] decimal = hexadecimalToDecimal(input);
        outputArray[0] = byteArrayToString(decimal);
        outputArray[1] = decimalToText(decimal);
        outputArray[2] = decimalToBase64(decimal);
        outputArray[3] = input;
        outputArray[4] = decimalToBinary(decimal);
        return outputArray;
    }


    private static String[] inputBinary (String input) {
        String[] outputArray = new String[5];
        byte[] decimal = binaryToDecimal(input);
        outputArray[0] = byteArrayToString(decimal);
        outputArray[1] = decimalToText(decimal);
        outputArray[2] = decimalToBase64(decimal);
        outputArray[3] = decimalToHexadecimal(decimal);
        outputArray[4] = input;
        return outputArray;
    }
}