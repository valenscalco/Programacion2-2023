export interface IOrden {
  id?: number;
  accionId?: number | null;
  accion?: string;
  operacion?: string;
  cantidad?: number;
  fechaOperacion?: string;
  modo?: string;
  operacionExitosa?: boolean;
  descripcion?: string | null;
  ejecutada?: boolean | null;
  reportada?: boolean | null;
  clienteId?: number;
}

export const defaultValue: Readonly<IOrden> = {
  operacionExitosa: false,
  ejecutada: false,
  reportada: false,
};
