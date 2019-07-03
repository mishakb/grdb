import sys
import os
from pathlib import Path
from collections import defaultdict
from ply.lex import lex
from ply.yacc import yacc

def entrystring (*args):
    if not args:
        return '\'\''
    else:
        return '\'' + str(*args) + '\''

tokens = ('DATA', 'EQUALS', 'COLON')

t_EQUALS = r'='
t_COLON = r':'
t_ignore_COMMENT = r'\#[^\n]*'

entrymap = {
    'Ndim_' : 'metricdimension',
    'constraint_' : 'metricconstraints',
    'Info_' : 'metricinfo',
    'Ref_' : 'metricreference',
    'Archive1_' : 'kshm_reference',
    'Archive2_' : 'skea_reference',
    'Archive3_' : 'hawking_ellis_reference',
}

def t_DATA (tok):
    r'[^#=:\n]+'
    tok.value = tok.value.strip()
    if tok.value in entrymap:
        tok.value = entrymap[tok.value]
    return tok

def t_newline (tok):
    r'\n+'
    tok.lexer.lineno += len(tok.value)

def t_error (tok):
    print('parse error: illegal token, %s' % tok.value)
    tok.lexer.skip(1)

def t_eof (tok):
    return None

def p_entry (p):
    '''entry : DATA COLON EQUALS DATA COLON'''
    if p[1] == 'metricdimension':
        p[0] = {p[1] : p[4]}
    else:
        p[0] = {p[1] : entrystring(p[4])}

def p_error (p):
    return None

lexer = lex()
parser = yacc()

SQL_TABLENAME = 'metrics'
SQL_VALUES = (
    'metricid',
    'metricdimension',
    'metricname',
    'x1_',
    'x2_',
    'x3_',
    'x4_',
    'g11_',
    'g12_',
    'g13_',
    'g14_',
    'g21_',
    'g22_',
    'g23_',
    'g24_',
    'g31_',
    'g32_',
    'g33_',
    'g34_',
    'g41_',
    'g42_',
    'g43_',
    'g44_',
    'metricinfo',
    'metricconstraints',
    'sig_',
    'complex_',
    'metricreference',
    'kshm_reference',
    'skea_reference',
    'hawking_ellis_reference',
    'b11_',
    'b12_',
    'b13_',
    'b14_',
    'b21_',
    'b22_',
    'b23_',
    'b24_',
    'b31_',
    'b32_',
    'b33_',
    'b34_',
    'b41_',
    'b42_',
    'b43_',
    'b44_',
    'bd11_',
    'bd12_',
    'bd13_',
    'bd14_',
    'bd21_',
    'bd22_',
    'bd23_',
    'bd24_',
    'bd31_',
    'bd32_',
    'bd33_',
    'bd34_',
    'bd41_',
    'bd42_',
    'bd43_',
    'bd44_',
    'metriclineelementhtml',
)

SQL_PREFIX = 'insert into ' + SQL_TABLENAME \
    + ' (' + ','.join(SQL_VALUES) + ') values ('
SQL_SUFFIX = ');'

if not os.path.exists('html'):
    raise RuntimeError('parsing requires html files to have been generated')

metricdata = {}
for path in sys.argv[1:]:
    metricname = os.path.splitext(os.path.basename(path))[0]
    entrydata = defaultdict(entrystring)
    entrydata.update({'metricname' : entrystring(metricname)})
    with open(path, 'r') as file:
        for line in file:
            pair = parser.parse(line)
            if pair:
                entrydata.update(pair)
    with open(Path('html/' + metricname + '.html'), 'r') as file:
        entrydata.update({'metriclineelementhtml' : entrystring(file.read())})
    metricdata.update({metricname : entrydata})

if not os.path.exists('sql'):
    os.mkdir('sql')

table_index = 0
for metric, data in metricdata.items():
    values = list(map(data.__getitem__, SQL_VALUES))
    values[0] = str(table_index)
    table_index += 1
    sql_command = SQL_PREFIX + ','.join(values) + SQL_SUFFIX
    with open(Path('sql/' + metric + '.sql'), 'w') as file:
        file.write(sql_command)
