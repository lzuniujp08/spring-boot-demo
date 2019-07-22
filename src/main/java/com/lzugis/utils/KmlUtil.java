package com.lzugis.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.lzugis.utils.kml.KmlLine;
import com.lzugis.utils.kml.KmlPoint;
import com.lzugis.utils.kml.KmlProperty;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Boundary;
import de.micromata.opengis.kml.v_2_2_0.Coordinate;
import de.micromata.opengis.kml.v_2_2_0.Folder;
import de.micromata.opengis.kml.v_2_2_0.Geometry;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.LineString;
import de.micromata.opengis.kml.v_2_2_0.LineStyle;
import de.micromata.opengis.kml.v_2_2_0.LinearRing;
import de.micromata.opengis.kml.v_2_2_0.MultiGeometry;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Point;
import de.micromata.opengis.kml.v_2_2_0.PolyStyle;
import de.micromata.opengis.kml.v_2_2_0.Polygon;
import de.micromata.opengis.kml.v_2_2_0.Style;
import de.micromata.opengis.kml.v_2_2_0.StyleSelector;

public class KmlUtil {
    public static void main(String[] args) throws NoSuchFieldException, SecurityException{
        String color = null;
        Integer width = null;
        List<KmlPoint> kmlPointList = new ArrayList<KmlPoint>();
        List<KmlLine> kmlLineList = new ArrayList<KmlLine>();
        KmlProperty kmlProperty = new KmlProperty();
        List<Geometry> polygon = null;
        List<Coordinate> coordinates;
        MultiGeometry multiGeometry = null;
        LineString lineString = null;
        LinearRing linearRing = null;
        Point point = null;
        final Kml kml = Kml.unmarshal(new File("C://x.kml"));
        Document document = (Document) kml.getFeature();
        Folder folder = (Folder) document.getFeature().get(1);
        int folderSize = folder.getFeature().size();
        for (int i = 0; i < folderSize; i++) {
            Placemark placemark = (Placemark) folder.getFeature().get(i);
            List<StyleSelector> style = placemark.getStyleSelector();
            for(int m=0 ; m<style.size() ; m++){
                Style s=(Style) style.get(m);
                PolyStyle polyStyle=s.getPolyStyle();
                LineStyle lineStyle = s.getLineStyle();
                if(polyStyle==null){
                    color = lineStyle.getColor();
                    width = (int) lineStyle.getWidth();
                }else{
                    color = polyStyle.getColor();
                }
            }
            String geometryNamess = placemark.getGeometry().toString().split("@")[0];
            String[] geometryNames = geometryNamess.split("\\.");
            String geometryName = geometryNames[geometryNames.length-1];
            if("MultiGeometry".equals(geometryName)){
                multiGeometry = (MultiGeometry)  placemark.getGeometry();
                polygon = multiGeometry.getGeometry();
                for(int j=0 ; j<polygon.size() ; j++){
                    Boundary outerBoundaryIs = ((Polygon) polygon.get(j)).getOuterBoundaryIs();
                    linearRing = outerBoundaryIs.getLinearRing();//面
                    coordinates = linearRing.getCoordinates();
                }
            }else if("LineString".equals(geometryName)){//线
                KmlLine kmlLine = new KmlLine();
                lineString = (LineString)  placemark.getGeometry();
                coordinates = lineString.getCoordinates();
                System.out.println(coordinates);
                kmlLineList.add(kmlLine);
            }else if("Point".equals(geometryName)){//点
                KmlPoint kmlPoint = new KmlPoint();
                point = (Point)  placemark.getGeometry();
                coordinates = point.getCoordinates();
                kmlPointList.add(kmlPoint);
            }else if("Polygon".equals(geometryName)){
                polygon = (List<Geometry>)  placemark.getGeometry();
                for(int j=0 ; j<polygon.size() ; j++){
                    Boundary outerBoundaryIs = ((Polygon) polygon.get(j)).getOuterBoundaryIs();
                    linearRing = outerBoundaryIs.getLinearRing();
                    coordinates = linearRing.getCoordinates();
                }
            }else{
                System.out.println("其他类型，请联系开发者补充..........................");
            }
        }
        kmlProperty.setKmlPoints(kmlPointList);
        kmlProperty.setKmlLines(kmlLineList);
        System.out.println();
    }
}
