# demo-crud-back
--aqui esta la creacion de los scripts correspondientes a la base de datos, la cual fue desarrollada en postgres


CREATE TABLE cliente 
(
    id_cliente serial NOT NULL,
    nombre character varying(100) COLLATE pg_catalog."default",
    apellido character varying(100) COLLATE pg_catalog."default",
    direccion character varying(80) COLLATE pg_catalog."default",
    telefono character varying(30) COLLATE pg_catalog."default",
    email character varying(30) COLLATE pg_catalog."default", 	
    CONSTRAINT cliente_pk PRIMARY KEY (id_cliente)
);

CREATE TABLE producto 
(
    id_producto serial NOT NULL,
    nombre character varying(100) COLLATE pg_catalog."default",
    precio integer,
    stock integer,
    CONSTRAINT producto_pk PRIMARY KEY (id_producto)
);

CREATE TABLE factura 
(
    num_factura serial NOT NULL,
    id_cliente integer,
    fecha timestamp,
    CONSTRAINT factura_pk PRIMARY KEY (num_factura),
    CONSTRAINT id_cli_factura_fk FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente) 
);

CREATE TABLE detalle 
(
    num_detalle serial NOT NULL,
    id_factura integer,
    id_producto integer,
    cantidad smallint,
    precio integer, 	 
    CONSTRAINT detalle_pk PRIMARY KEY (num_detalle),
    CONSTRAINT id_fac_detalle_fk FOREIGN KEY (id_factura) REFERENCES factura (num_factura),
    CONSTRAINT id_pro_detalle_fk FOREIGN KEY (id_producto) REFERENCES producto (id_producto) 
);

INSERT INTO cliente (id_cliente, nombre, apellido, direccion,telefono,email) VALUES (1,'Diego','Hernadez','carrera 3', 'dh@gmail.com');
INSERT INTO producto (id_producto, nombre, precio, stock) VALUES (1,'tornillo',500,7);
