import React, { useState, useEffect } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { Button, Table } from 'reactstrap';
import { Translate, TextFormat, getSortState } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSort, faSortUp, faSortDown } from '@fortawesome/free-solid-svg-icons';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ASC, DESC, SORT } from 'app/shared/util/pagination.constants';
import { overrideSortStateWithQueryParams } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntities } from './orden.reducer';

export const Orden = () => {
  const dispatch = useAppDispatch();

  const pageLocation = useLocation();
  const navigate = useNavigate();

  const [sortState, setSortState] = useState(overrideSortStateWithQueryParams(getSortState(pageLocation, 'id'), pageLocation.search));

  const ordenList = useAppSelector(state => state.orden.entities);
  const loading = useAppSelector(state => state.orden.loading);

  const getAllEntities = () => {
    dispatch(
      getEntities({
        sort: `${sortState.sort},${sortState.order}`,
      }),
    );
  };

  const sortEntities = () => {
    getAllEntities();
    const endURL = `?sort=${sortState.sort},${sortState.order}`;
    if (pageLocation.search !== endURL) {
      navigate(`${pageLocation.pathname}${endURL}`);
    }
  };

  useEffect(() => {
    sortEntities();
  }, [sortState.order, sortState.sort]);

  const sort = p => () => {
    setSortState({
      ...sortState,
      order: sortState.order === ASC ? DESC : ASC,
      sort: p,
    });
  };

  const handleSyncList = () => {
    sortEntities();
  };

  const getSortIconByFieldName = (fieldName: string) => {
    const sortFieldName = sortState.sort;
    const order = sortState.order;
    if (sortFieldName !== fieldName) {
      return faSort;
    } else {
      return order === ASC ? faSortUp : faSortDown;
    }
  };

  return (
    <div>
      <h2 id="orden-heading" data-cy="OrdenHeading">
        <Translate contentKey="trabajoFinalApp.orden.home.title">Ordens</Translate>
        <div className="d-flex justify-content-end">
          <Button className="me-2" color="info" onClick={handleSyncList} disabled={loading}>
            <FontAwesomeIcon icon="sync" spin={loading} />{' '}
            <Translate contentKey="trabajoFinalApp.orden.home.refreshListLabel">Refresh List</Translate>
          </Button>
          <Link to="/orden/new" className="btn btn-primary jh-create-entity" id="jh-create-entity" data-cy="entityCreateButton">
            <FontAwesomeIcon icon="plus" />
            &nbsp;
            <Translate contentKey="trabajoFinalApp.orden.home.createLabel">Create new Orden</Translate>
          </Link>
        </div>
      </h2>
      <div className="table-responsive">
        {ordenList && ordenList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th className="hand" onClick={sort('id')}>
                  <Translate contentKey="trabajoFinalApp.orden.id">ID</Translate> <FontAwesomeIcon icon={getSortIconByFieldName('id')} />
                </th>
                <th className="hand" onClick={sort('accionId')}>
                  <Translate contentKey="trabajoFinalApp.orden.accionId">Accion Id</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('accionId')} />
                </th>
                <th className="hand" onClick={sort('accion')}>
                  <Translate contentKey="trabajoFinalApp.orden.accion">Accion</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('accion')} />
                </th>
                <th className="hand" onClick={sort('operacion')}>
                  <Translate contentKey="trabajoFinalApp.orden.operacion">Operacion</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('operacion')} />
                </th>
                <th className="hand" onClick={sort('cantidad')}>
                  <Translate contentKey="trabajoFinalApp.orden.cantidad">Cantidad</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('cantidad')} />
                </th>
                <th className="hand" onClick={sort('fechaOperacion')}>
                  <Translate contentKey="trabajoFinalApp.orden.fechaOperacion">Fecha Operacion</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('fechaOperacion')} />
                </th>
                <th className="hand" onClick={sort('modo')}>
                  <Translate contentKey="trabajoFinalApp.orden.modo">Modo</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('modo')} />
                </th>
                <th className="hand" onClick={sort('operacionExitosa')}>
                  <Translate contentKey="trabajoFinalApp.orden.operacionExitosa">Operacion Exitosa</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('operacionExitosa')} />
                </th>
                <th className="hand" onClick={sort('descripcion')}>
                  <Translate contentKey="trabajoFinalApp.orden.descripcion">Descripcion</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('descripcion')} />
                </th>
                <th className="hand" onClick={sort('ejecutada')}>
                  <Translate contentKey="trabajoFinalApp.orden.ejecutada">Ejecutada</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('ejecutada')} />
                </th>
                <th className="hand" onClick={sort('reportada')}>
                  <Translate contentKey="trabajoFinalApp.orden.reportada">Reportada</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('reportada')} />
                </th>
                <th className="hand" onClick={sort('clienteId')}>
                  <Translate contentKey="trabajoFinalApp.orden.clienteId">Cliente Id</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('clienteId')} />
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {ordenList.map((orden, i) => (
                <tr key={`entity-${i}`} data-cy="entityTable">
                  <td>
                    <Button tag={Link} to={`/orden/${orden.id}`} color="link" size="sm">
                      {orden.id}
                    </Button>
                  </td>
                  <td>{orden.accionId}</td>
                  <td>{orden.accion}</td>
                  <td>{orden.operacion}</td>
                  <td>{orden.cantidad}</td>
                  <td>{orden.fechaOperacion ? <TextFormat type="date" value={orden.fechaOperacion} format={APP_DATE_FORMAT} /> : null}</td>
                  <td>{orden.modo}</td>
                  <td>{orden.operacionExitosa ? 'true' : 'false'}</td>
                  <td>{orden.descripcion}</td>
                  <td>{orden.ejecutada ? 'true' : 'false'}</td>
                  <td>{orden.reportada ? 'true' : 'false'}</td>
                  <td>{orden.clienteId}</td>
                  <td className="text-end">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`/orden/${orden.id}`} color="info" size="sm" data-cy="entityDetailsButton">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`/orden/${orden.id}/edit`} color="primary" size="sm" data-cy="entityEditButton">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button
                        onClick={() => (location.href = `/orden/${orden.id}/delete`)}
                        color="danger"
                        size="sm"
                        data-cy="entityDeleteButton"
                      >
                        <FontAwesomeIcon icon="trash" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.delete">Delete</Translate>
                        </span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && (
            <div className="alert alert-warning">
              <Translate contentKey="trabajoFinalApp.orden.home.notFound">No Ordens found</Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

export default Orden;
