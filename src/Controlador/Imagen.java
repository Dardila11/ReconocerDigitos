/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author danielardila
 */
public class Imagen {
    
    // Ancho maximo de la imagen
    public static final int ANCHO_MAXIMO = 28;
    // Alto maximo de la imagen
    public static final int ALTO_MAXIMO = 28;  
    // Matriz de colores de la imagen
    private Color bitmap[][];
    // Ancho de la imagen
    private int ancho;
    // Alto de la imagen
    private int alto;

    public int getAncho() {
        return ancho;
    }
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    public int getAlto() {
        return alto;
    }
    public void setAlto(int alto) {
        this.alto = alto;
    }
    
    
    
    /**
     * Crea una imagen a partir de la ruta del archivo donde esta la imagen original en BMP. 
     * La imagen numera los píxeles desde la esquina superior izquierda de la imagen con
     * (0,0). La coordenada X ve de 0 hasta el ancho-1 y la coordenada Y va de 0 a el alto-1 
     * Si la imagen es de ancho mayor al ANCHO_MAXIMO o con altura mayor a ALTO_MAXIMO,
     * la imagen se recorta hasta los límites.
     * @param archivo Nombre y ruta del archivo. archivo != null.
     * @throws IOException Error al leer el archivo
     */
    public Imagen( String archivo ) throws IOException
    {
        bitmap = new Color[ALTO_MAXIMO][ANCHO_MAXIMO];
        cargarImagen( archivo );
    }
    
    /**
     * Carga la imagen que se encuentra en el archivo
     * @param nombreArchivo - nombre y ruta del archivo
     * @throws IOException Error al cargar la imagen
     */
    private void cargarImagen( String nombreArchivo ) throws IOException{
        File archivo = new File( nombreArchivo );
        BufferedImage bmp;

        try{
            bmp = ImageIO.read( archivo );
        }
        catch( IOException e ){
            throw new IOException( "No se encuentra la imagen" );
        }

        if( bmp.getWidth( ) < ANCHO_MAXIMO )
            ancho = bmp.getWidth( );
        else
            ancho = ANCHO_MAXIMO;

        if( bmp.getHeight( ) < ALTO_MAXIMO )
            alto = bmp.getHeight( );
        else
            alto = ALTO_MAXIMO;

        for( int i = 0; i < alto; i++ )
            for( int j = 0; j < ancho; j++ )
            {
                bitmap[ i ][ j ] = new Color( bmp.getRGB( j, i ) );
            }
    }
    
    /**
     * Binarización: Consiste en llevar cada píxel de una imagen a negro o blanco. 
     * Para ello se requiere un umbral: si el color del píxel está por encima o igual se lleva a
     * blanco y si está por debajo se lleva a negro.
     * @param umbral Umbral para la binarización.
     */
    public void binarizarImagenRGB( double umbral )
    {
        //Recorre la matriz de la imagen. Aquellos puntos con color menor o
        // igual al umbral los lleva a blanco y los mayores al negro.
        for( int i = 0; i < alto; i++ )
            for( int j = 0; j < ancho; j++ )
            {
                Color pixel = bitmap[ i ][ j ];
                int promedio = ( pixel.getBlue( ) + pixel.getGreen( ) + pixel.getRed( ) ) / 3;
                if( promedio < umbral )
                    bitmap[ i ][ j ] = Color.BLACK;
                else
                    bitmap[ i ][ j ] = Color.WHITE;
            }
    }
      
}
