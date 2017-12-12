package com.example.madalina.proiect;

import android.os.AsyncTask;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Madalina on 12/5/2016.
 */

public class DownloadXML extends AsyncTask<String,Void,List<Local>>

{
  // private int contor=10;
    @Override
    protected List<Local> doInBackground(String... params) {
        List<Local> listaLocaluriInPlus=new ArrayList<Local>();
        try {
            URL url=new URL(params[0]);
            HttpURLConnection conexiune=(HttpURLConnection)url.openConnection();
            InputStream is=conexiune.getInputStream();
            DocumentBuilderFactory fabrica=DocumentBuilderFactory.newInstance();
            DocumentBuilder docB=fabrica.newDocumentBuilder();
            Document doc=docB.parse(is);

            if(doc!=null)
            {
                NodeList lista=doc.getElementsByTagName("local");
                for(int i=0;i<lista.getLength();i++)
                {
                    Node nod=lista.item(i);
                    if(nod!=null &&nod.getNodeType()==Node.ELEMENT_NODE)
                    {
                        Element element=(Element)nod;
                        Local loc=new Local(element.getAttribute("denumire"),
                                element.getAttribute("descriere"),
                                element.getAttribute("site"),
                                element.getAttribute("tip"),
                                Float.parseFloat(element.getAttribute("nota")),
                                null);
                        Menu.contor++;
                        listaLocaluriInPlus.add(loc);
                    }
                }
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return listaLocaluriInPlus;
    }
}
