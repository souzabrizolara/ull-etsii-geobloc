package com.geobloc.activities;

import java.util.ArrayList;
import java.util.List;

import com.geobloc.activities.NewTextReader;
import com.geobloc.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.geobloc.xml.FormTextField;
import com.geobloc.xml.ITextField;
import com.geobloc.xml.TextXMLWriter;

public class StaticFormPrototype extends Activity {
	
	private EditText numForm;
	private EditText inspector;
	private EditText numVisita;
	private EditText observaciones;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.static_form_prototype);
        
        initialConfig();
    }
    
    private void initialConfig() {
    	numForm = (EditText) findViewById(R.id.EditText01);
    	inspector = (EditText) findViewById(R.id.EditText02);
    	numVisita = (EditText) findViewById(R.id.EditText03);
    	observaciones = (EditText) findViewById(R.id.EditText04);
    }
    
    public void enviarOnClickHandler (View target) {
    	XMLExample1();
    }
    
    private List<ITextField> getFields() {
    	List<ITextField> fields = new ArrayList<ITextField>();
    	FormTextField field;
    	
    	// numForm
    	field = new FormTextField();
    	field.setFieldName("numForm");
    	field.setFieldValue(numForm.getText().toString());
    	fields.add(field);
    	// inspector
    	field = new FormTextField();
    	field.setFieldName("inspector");
    	field.setFieldValue(inspector.getText().toString());
    	fields.add(field);
    	// numVisita
    	field = new FormTextField();
    	field.setFieldName("numVisita");
    	field.setFieldValue(numVisita.getText().toString());
    	fields.add(field);
    	// observaciones
    	field = new FormTextField();
    	field.setFieldName("observaciones");
    	field.setFieldValue(observaciones.getText().toString());
    	fields.add(field);
    	
    	return fields;
    }
    
    private void XMLExample1() {
    	
    	TextXMLWriter writer = new TextXMLWriter();
    	String xml = writer.WriteXML(this.getFields());
    	
    	//TextForm tf = new TextForm();
    	//tf.setFields(this.getFields());
    	
    	//String xml = XStreamXMLWriter.WriteXML(tf);
    	//String xml = tf.ToXML();
    	
    	Intent i = new Intent(this, NewTextReader.class);
    	i.putExtra(NewTextReader.__TEXT_READER_TEXT__, xml);
    	startActivity(i);
    	
    }
    
}

